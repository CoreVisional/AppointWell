# AppointWell
AppointWell is a clinic appointment management system created using Java Swing with Maven in Netbeans. In addition, this project uses file system as data storage.

There are two types of users in this system: **Patient** and **Clinic Staff**

&rarr; **Patient**
* Patient can view available timeslot
* Patient can book individual appointment
* Patient can individual appointment
* Patient can track personal appointment history

&rarr; **Clinic Staff**
* Clinic staff can add, edit, and remove timeslot from the timetable
* Clinic staff can add, edit, and remove a doctor from the system
* Clinic staff can confirm or cancel the appointment made by patient
* Clinic staff can track all patients' appointment history
* Clinic staff can track daily appointment

## How To Run
1. Run `git clone https://github.com/CoreVisional/AppointWell.git`
2. Launch Apache Netbeans
3. Go to File > Open Project > Navigate to where you cloned this repository
4. Once loaded, right-click on the AppointWell root folder, and select "Clean and Build".
5. Once done, expand the `src/` folder until you find `AppointWell.java` file. Click into this file and run the project. The first display should be the login page.