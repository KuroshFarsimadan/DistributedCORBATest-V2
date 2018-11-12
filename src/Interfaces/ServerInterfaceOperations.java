package Interfaces;


/**
* Interfaces/ServerInterfaceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServerInterface.idl
* 25. lokakuuta 2018 8.54.09 EDT
*/

public interface ServerInterfaceOperations 
{
  String studentSemesterCourseCount (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder semester);
  String swapCourse (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder newCourseID, org.omg.CORBA.StringHolder oldCourseID);
  String addCourse (org.omg.CORBA.StringHolder courseID, org.omg.CORBA.StringHolder semester);
  String removeCourse (org.omg.CORBA.StringHolder courseID, org.omg.CORBA.StringHolder semester);
  String listCourseAvailability (org.omg.CORBA.StringHolder semester);
  String enrolCourse (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder courseID, org.omg.CORBA.StringHolder semester);
  String getClassSchedule (org.omg.CORBA.StringHolder studentID);
  String dropCourse (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder courseID);
  void shutdown ();
} // interface ServerInterfaceOperations
