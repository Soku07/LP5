rmi : 
    T1 : 
        javac *.java
        rmic AddServerImpl

    T2 : 
        rmiregistry
    
    T3
    java AddServer
    T4 
    java AddCLient

Corba : 
T1
idlj -fall ReverseModule.idl
javac *.java ReverseModule/*.java
orbd -ORBInitialPort 1056&
java ReverseServer -ORBInitialPort 1056& 

T2
java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost

MPI : 
export MPJ_HOME=/home/ubuntu/Downloads/mpj-v0_44
export PATH=$MPJ_HOME/bin:$PATH
javac -cp $MPJ_HOME/lib/mpj.jar ArrSum.java
$MPJ_HOME/bin/mpjrun.sh -np 4 ArrSum  // Specified value of n=4 here 

berkeley:
T1
javac *.java
rmiregistry

run clock and main clock files on new terminals


Instructions for Calculator Webservice:
Create new project 
Rightclick on project and click on Webservice
give package as com.myservice
click on form scratch and finish
create methods for operations using add operations interface
return statements
right click on project, click on build, deploy.
click on webservice where functions exist and click on test

Create new project for client
create form in index.html with action name "CalculatorServelet" // this name should match with CalculatorServelet
add html elements to take inputs and submit


rightclick on client project and select webservice client. select project where functions were created and click finish
copy name of action in index.html for calculatorservelet.
rightclick on client project->new->servelet 
the name of the servelet should be same as action, CalculatorServelet in this CalculatorServelet
tick the checkbox of deployment and click finish

drag methods
declare var : double num1 = Double.parseDouble(request.getParameter("number2"))
change the displays

Rightclick on client -> clean and build
right click on index.html and click on run file