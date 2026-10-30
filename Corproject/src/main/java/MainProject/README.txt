JAVA SWING COR SYSTEM

Files:
- CORSwingApp.java      Main program
- CORInputFrame.java    Input interface
- COROutputFrame.java   COR output interface
- CORData.java          Tuition and assessment calculations
- Subject.java          Subject model class

Compile:
    javac *.java

Run:
    java CORSwingApp

Basic formula:
    Tuition Fee = Total Units * Tuition Fee per Unit
    Total Assessment = Tuition Fee + Miscellaneous Fee + ID Fee + Laboratory Fees
    Final Assessment = Total Assessment - Scholarship Deduction

Laboratory subjects with LAB in the code or LABORATORY in the title receive a
sample laboratory fee of 4000. You can change the fee rules in CORData.java.
