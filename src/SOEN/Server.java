package SOEN;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Interfaces.ServerInterface;
import Interfaces.ServerInterfaceHelper;

public class Server {

	public static void main(String[] args) throws RemoteException {

		/*
		 * 
		 * SOEN - RMI server starts at 8080 - UDP server starts at 8081
		 * 
		 * INSE - RMI server starts at 9090 - UDP server starts at 9091
		 * 
		 * COMP - RMI server starts at 10010 - UDP server starts at 10011
		 */
		ServerImpl exportedObj = new ServerImpl();

		Runnable task = () -> {
			startCORBA(args, exportedObj);
		};

		Runnable task2 = () -> {
			try {
				startUDP(8081, exportedObj);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		};

		Thread thread = new Thread(task);
		Thread thread2 = new Thread(task2);

		thread.start();
		thread2.start();

	}

	/**
	 * UDP Server related configurations from this point onward.
	 * 
	 * @param exportedObj
	 * 
	 * @param port
	 */
	// This method starts the UDP service
	private synchronized static void startUDP(int portVar, ServerImpl exportedObj) throws RemoteException {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(portVar);
			byte[] buffer = new byte[1000];
			System.out.println("UDP Server ready at port " + portVar);

			while (true) {

				// The three lines of code below are responsible for blocking the UDP method
				// until a new client request is received.
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				String requestData = request.getData() + "";

				System.out.println("startUDP: " + portVar + " is " + new String(request.getData()));

				System.out.println("Client sent " + new String(request.getData()));

				// I want to get the data again in another byte array so that I will actually
				// send the right String value after receiving it.
				byte[] bufferCopy = new byte[request.getLength()];

				// Copies an array from the specified source array, beginning at the specified
				// position, to the specified position of the destination array.
				System.arraycopy(request.getData(), request.getOffset(), bufferCopy, 0, request.getLength());

				// Creating a new string for the copy
				String bufferData = new String(bufferCopy);
				String stringMessage = "";

				try {
					if (bufferData.equalsIgnoreCase("winter") || bufferData.equalsIgnoreCase("summer")
							|| bufferData.equalsIgnoreCase("spring") || bufferData.equalsIgnoreCase("fall")) {
						stringMessage = "" + exportedObj.semesterCourses(bufferData);
					} else {
						// 0 = switch method (methodName), 1 = studentID, 2 = newCourseID, 3 =
						// oldCourseID
						String[] splitData = bufferData.split("\\s+");

						if (bufferData.contains("removeStudentCourse")) {
							stringMessage = ""
									+ exportedObj.removeStudentCourse(splitData[1], splitData[2], splitData[3]);
						} else if (bufferData.contains("addStudentCourse")) {
							stringMessage = "" + exportedObj.addStudentCourse(splitData[1], splitData[2], splitData[3]);
						} else if (bufferData.contains("revertRemove")) {
							// studentid, courseid, semester
							stringMessage = "" + exportedObj.revertRemove(splitData[1], splitData[2]);
						} else if (bufferData.contains("revertAdd")) {
							// studentid, courseid, semester
							stringMessage = "" + exportedObj.revertAdd(splitData[1], splitData[2]);
						}

					}
				} catch (Exception e) {
					stringMessage = "An error occurred: " + e;
				}

				byte[] message = stringMessage.getBytes();

				DatagramPacket reply = new DatagramPacket(message, message.length, request.getAddress(),
						request.getPort());

				aSocket.send(reply);
			}
		} catch (SocketException e) {
			System.out.println("Socket error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO error: " + e.getMessage());
		}
		// We don't want to close the UDP connections
		finally {
			if (aSocket != null)
				aSocket.close();
		}

	}

	// This method starts the RMI service
	private static void startCORBA(String[] args, ServerImpl exportedObj) {
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			/*
			 * An object adapter is the mechanism that connects a request using an object
			 * reference with the proper code to service that request. The Portable Object
			 * Adapter, or POA, is a particular type of object adapter that is defined by
			 * the CORBA specification.
			 */
			// -ORBInitialPort 1050 -ORBInitialHost localhost
			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB

			exportedObj.setORB(orb);

			// get object reference from the servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(exportedObj);
			ServerInterface href = ServerInterfaceHelper.narrow(ref);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			NameComponent path[] = ncRef.to_name("SOEN");
			ncRef.rebind(path, href);

			System.out.println("Addition Server ready and waiting ...");

			// wait for invocations from clients
			// for (;;) {
			while (true) {
				System.out.println("Looping");
				orb.run();
			}

			// }
		}

		catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}

		System.out.println("HelloServer Exiting ...");
	}

}
