package unit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class ObjectInOutStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("c:/temp2/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Member m1 = new Member("admin", "임채리");
		int[] arr = {1,2,3};
		oos.writeObject(m1);
		oos.writeObject(arr);
		oos.close(); fos.close();
		
		FileInputStream fis = new FileInputStream("c:/temp2/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Member m2 = (Member)ois.readObject();
		int[] arr2 = (int[])ois.readObject();
		
		System.out.println(m2);
		System.out.println(Arrays.toString(arr2));
		
		ois.close(); fis.close();
		
	}

}

class Member implements Serializable{
	private static final long serialVersionUID = -4359715877453144038L;
	
	private String id;
	private String name;
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
	
}
