package Interfaces;


/**
* Interfaces/_ServerInterfaceStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServerInterface.idl
* 25. lokakuuta 2018 8.54.09 EDT
*/

public class _ServerInterfaceStub extends org.omg.CORBA.portable.ObjectImpl implements Interfaces.ServerInterface
{

  public String studentSemesterCourseCount (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder semester)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("studentSemesterCourseCount", true);
                $out.write_string (studentID.value);
                $out.write_string (semester.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                studentID.value = $in.read_string ();
                semester.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return studentSemesterCourseCount (studentID, semester        );
            } finally {
                _releaseReply ($in);
            }
  } // studentSemesterCourseCount

  public String swapCourse (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder newCourseID, org.omg.CORBA.StringHolder oldCourseID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("swapCourse", true);
                $out.write_string (studentID.value);
                $out.write_string (newCourseID.value);
                $out.write_string (oldCourseID.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                studentID.value = $in.read_string ();
                newCourseID.value = $in.read_string ();
                oldCourseID.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return swapCourse (studentID, newCourseID, oldCourseID        );
            } finally {
                _releaseReply ($in);
            }
  } // swapCourse

  public String addCourse (org.omg.CORBA.StringHolder courseID, org.omg.CORBA.StringHolder semester)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addCourse", true);
                $out.write_string (courseID.value);
                $out.write_string (semester.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                courseID.value = $in.read_string ();
                semester.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return addCourse (courseID, semester        );
            } finally {
                _releaseReply ($in);
            }
  } // addCourse

  public String removeCourse (org.omg.CORBA.StringHolder courseID, org.omg.CORBA.StringHolder semester)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("removeCourse", true);
                $out.write_string (courseID.value);
                $out.write_string (semester.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                courseID.value = $in.read_string ();
                semester.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return removeCourse (courseID, semester        );
            } finally {
                _releaseReply ($in);
            }
  } // removeCourse

  public String listCourseAvailability (org.omg.CORBA.StringHolder semester)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("listCourseAvailability", true);
                $out.write_string (semester.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                semester.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return listCourseAvailability (semester        );
            } finally {
                _releaseReply ($in);
            }
  } // listCourseAvailability

  public String enrolCourse (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder courseID, org.omg.CORBA.StringHolder semester)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("enrolCourse", true);
                $out.write_string (studentID.value);
                $out.write_string (courseID.value);
                $out.write_string (semester.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                studentID.value = $in.read_string ();
                courseID.value = $in.read_string ();
                semester.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return enrolCourse (studentID, courseID, semester        );
            } finally {
                _releaseReply ($in);
            }
  } // enrolCourse

  public String getClassSchedule (org.omg.CORBA.StringHolder studentID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getClassSchedule", true);
                $out.write_string (studentID.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                studentID.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getClassSchedule (studentID        );
            } finally {
                _releaseReply ($in);
            }
  } // getClassSchedule

  public String dropCourse (org.omg.CORBA.StringHolder studentID, org.omg.CORBA.StringHolder courseID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("dropCourse", true);
                $out.write_string (studentID.value);
                $out.write_string (courseID.value);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                studentID.value = $in.read_string ();
                courseID.value = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return dropCourse (studentID, courseID        );
            } finally {
                _releaseReply ($in);
            }
  } // dropCourse

  public void shutdown ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("shutdown", false);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                shutdown (        );
            } finally {
                _releaseReply ($in);
            }
  } // shutdown

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Interfaces/ServerInterface:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ServerInterfaceStub
