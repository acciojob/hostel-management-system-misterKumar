package com.driver;

import java.util.HashMap;
import java.util.Map;

public class HostelManagement {
    private Map<String, String> studentRoomMap;

    public HostelManagement() {
        this.studentRoomMap = new HashMap<>();
    }

    public void addStudent(String studentId, String name) {
    	//your code goes here
        if(!studentRoomMap.containsKey(studentId)){
            studentRoomMap.put(studentId,name);
            HostelLogger.logInfo("Student " + name + " with ID " + studentId + " added.");
        }
        else{
            HostelLogger.logWarning("Student with ID " + studentId + " already exists.");
        }
    }

    public void allocateRoom(String studentId, String roomNumber) {
    	//your code goes here
        if (studentRoomMap.containsKey(studentId)) {
            if (!studentRoomMap.containsValue(roomNumber)) {
                studentRoomMap.put(studentId, roomNumber);
                HostelLogger.logInfo("Room " + roomNumber + " allocated to student with ID " + studentId);
            } else {
                HostelLogger.logWarning("Student with ID " + studentId + " already allocated a room.");
            }
        } else {
            HostelLogger.logWarning("Invalid student ID: " + studentId);
        }
    }

    public boolean isRoomAvailable(String roomNumber) {
    	//your code goes here
        for (String allocatedRoom : studentRoomMap.values()) {
            if (allocatedRoom.equals(roomNumber)) {
                HostelLogger.logInfo("Room " + roomNumber + " is occupied.");
                return false;
            }
        }
        HostelLogger.logInfo("Room " + roomNumber + " is available for allocation.");
        return true;
    }

    public static void main(String[] args) {
        HostelManagement hostelManagement = new HostelManagement();

        // Test Cases
        hostelManagement.addStudent("S001", "Alice");
        hostelManagement.addStudent("S002", "Bob");

        hostelManagement.allocateRoom("S001", "101");
        hostelManagement.allocateRoom("S003", "102"); // Invalid student ID

        System.out.println("Is Room 101 available? " + hostelManagement.isRoomAvailable("101")); // Should print false
        System.out.println("Is Room 102 available? " + hostelManagement.isRoomAvailable("102")); // Should print true
    }
}
