package Interfaces;


/**
* Interfaces/ServerInterfaceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServerInterface.idl
* 25. lokakuuta 2018 8.54.09 EDT
*/

abstract public class ServerInterfaceHelper
{
  private static String  _id = "IDL:Interfaces/ServerInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, Interfaces.ServerInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Interfaces.ServerInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Interfaces.ServerInterfaceHelper.id (), "ServerInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Interfaces.ServerInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ServerInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Interfaces.ServerInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Interfaces.ServerInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Interfaces.ServerInterface)
      return (Interfaces.ServerInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Interfaces._ServerInterfaceStub stub = new Interfaces._ServerInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Interfaces.ServerInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Interfaces.ServerInterface)
      return (Interfaces.ServerInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Interfaces._ServerInterfaceStub stub = new Interfaces._ServerInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
