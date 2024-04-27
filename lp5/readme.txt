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