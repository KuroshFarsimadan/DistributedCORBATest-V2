package Interfaces;


/**
* Interfaces/ServerInterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServerInterface.idl
* 25. lokakuuta 2018 8.54.09 EDT
*/

public abstract class ServerInterfacePOA extends org.omg.PortableServer.Servant
 implements Interfaces.ServerInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("studentSemesterCourseCount", new java.lang.Integer (0));
    _methods.put ("swapCourse", new java.lang.Integer (1));
    _methods.put ("addCourse", new java.lang.Integer (2));
    _methods.put ("removeCourse", new java.lang.Integer (3));
    _methods.put ("listCourseAvailability", new java.lang.Integer (4));
    _methods.put ("enrolCourse", new java.lang.Integer (5));
    _methods.put ("getClassSchedule", new java.lang.Integer (6));
    _methods.put ("dropCourse", new java.lang.Integer (7));
    _methods.put ("shutdown", new java.lang.Integer (8));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Interfaces/ServerInterface/studentSemesterCourseCount
       {
         org.omg.CORBA.StringHolder studentID = new org.omg.CORBA.StringHolder ();
         studentID.value = in.read_string ();
         org.omg.CORBA.StringHolder semester = new org.omg.CORBA.StringHolder ();
         semester.value = in.read_string ();
         String $result = null;
         $result = this.studentSemesterCourseCount (studentID, semester);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (studentID.value);
         out.write_string (semester.value);
         break;
       }

       case 1:  // Interfaces/ServerInterface/swapCourse
       {
         org.omg.CORBA.StringHolder studentID = new org.omg.CORBA.StringHolder ();
         studentID.value = in.read_string ();
         org.omg.CORBA.StringHolder newCourseID = new org.omg.CORBA.StringHolder ();
         newCourseID.value = in.read_string ();
         org.omg.CORBA.StringHolder oldCourseID = new org.omg.CORBA.StringHolder ();
         oldCourseID.value = in.read_string ();
         String $result = null;
         $result = this.swapCourse (studentID, newCourseID, oldCourseID);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (studentID.value);
         out.write_string (newCourseID.value);
         out.write_string (oldCourseID.value);
         break;
       }

       case 2:  // Interfaces/ServerInterface/addCourse
       {
         org.omg.CORBA.StringHolder courseID = new org.omg.CORBA.StringHolder ();
         courseID.value = in.read_string ();
         org.omg.CORBA.StringHolder semester = new org.omg.CORBA.StringHolder ();
         semester.value = in.read_string ();
         String $result = null;
         $result = this.addCourse (courseID, semester);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (courseID.value);
         out.write_string (semester.value);
         break;
       }

       case 3:  // Interfaces/ServerInterface/removeCourse
       {
         org.omg.CORBA.StringHolder courseID = new org.omg.CORBA.StringHolder ();
         courseID.value = in.read_string ();
         org.omg.CORBA.StringHolder semester = new org.omg.CORBA.StringHolder ();
         semester.value = in.read_string ();
         String $result = null;
         $result = this.removeCourse (courseID, semester);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (courseID.value);
         out.write_string (semester.value);
         break;
       }

       case 4:  // Interfaces/ServerInterface/listCourseAvailability
       {
         org.omg.CORBA.StringHolder semester = new org.omg.CORBA.StringHolder ();
         semester.value = in.read_string ();
         String $result = null;
         $result = this.listCourseAvailability (semester);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (semester.value);
         break;
       }

       case 5:  // Interfaces/ServerInterface/enrolCourse
       {
         org.omg.CORBA.StringHolder studentID = new org.omg.CORBA.StringHolder ();
         studentID.value = in.read_string ();
         org.omg.CORBA.StringHolder courseID = new org.omg.CORBA.StringHolder ();
         courseID.value = in.read_string ();
         org.omg.CORBA.StringHolder semester = new org.omg.CORBA.StringHolder ();
         semester.value = in.read_string ();
         String $result = null;
         $result = this.enrolCourse (studentID, courseID, semester);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (studentID.value);
         out.write_string (courseID.value);
         out.write_string (semester.value);
         break;
       }

       case 6:  // Interfaces/ServerInterface/getClassSchedule
       {
         org.omg.CORBA.StringHolder studentID = new org.omg.CORBA.StringHolder ();
         studentID.value = in.read_string ();
         String $result = null;
         $result = this.getClassSchedule (studentID);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (studentID.value);
         break;
       }

       case 7:  // Interfaces/ServerInterface/dropCourse
       {
         org.omg.CORBA.StringHolder studentID = new org.omg.CORBA.StringHolder ();
         studentID.value = in.read_string ();
         org.omg.CORBA.StringHolder courseID = new org.omg.CORBA.StringHolder ();
         courseID.value = in.read_string ();
         String $result = null;
         $result = this.dropCourse (studentID, courseID);
         out = $rh.createReply();
         out.write_string ($result);
         out.write_string (studentID.value);
         out.write_string (courseID.value);
         break;
       }

       case 8:  // Interfaces/ServerInterface/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Interfaces/ServerInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ServerInterface _this() 
  {
    return ServerInterfaceHelper.narrow(
    super._this_object());
  }

  public ServerInterface _this(org.omg.CORBA.ORB orb) 
  {
    return ServerInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class ServerInterfacePOA
