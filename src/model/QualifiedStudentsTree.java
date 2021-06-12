package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class QualifiedStudentsTree {

	private Student root;
	
	public QualifiedStudentsTree() {
		
	}

	public void addStudent(String name, String lastName, String email, String code) {
		Student s = new Student(name, lastName, email, code);
		if(root == null) {
			root = s;
		}else {
			addStudent(root, s);
		}
	}

	private void addStudent(Student current, Student newStudent) {
		if((newStudent.getName().compareToIgnoreCase(current.getName())) < 0) {
			if(current.getLeft() != null) {
				addStudent(current.getLeft(), newStudent);
			}
			else {
				current.setLeft(newStudent);
				newStudent.setParent(current);
			}
		} 
		else {
			if(current.getRight() != null) {
				addStudent(current.getRight(), newStudent);
			}
			else {
				current.setRight(newStudent);
				newStudent.setParent(current);
			}
		}
	}
	
	//EXPORT TREE IN A TEXT FILE
	
	public void exportTree(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		Student current = root;
		String treeInfo = exportTree(current, "", separator);
		pw.write(treeInfo);
		pw.close();
	}
	
	private String exportTree(Student current, String treeInfo, String separator) {
		if(current != null) {
			exportTree(current.getLeft(), treeInfo, separator);
			treeInfo += current.nodeToString(separator) + "\n";
			exportTree(current.getRight(), treeInfo, separator);
		}
		return treeInfo;
	}
	
}
