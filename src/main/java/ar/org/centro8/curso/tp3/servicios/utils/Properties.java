package ar.org.centro8.curso.tp3.servicios.utils;

import java.net.InetAddress;
import java.time.LocalDate;
import java.util.Calendar;

public class Properties {

    public static String getSO(){
        return  System.getProperty("os.name")+" - "+
                System.getProperty("os.version")+" - "+
                System.getProperty("os.arch");
    }

    public static String getJava(){
        return  System.getProperty("java.vm.name")+" - "+
                System.getProperty("java.vm.version");
    }

    public static String getUser(){
        return System.getProperty("user.name");
    }

    public static String getLocation(){
        return Calendar
                        .getInstance()
                        .getTimeZone()
                        .getID()
                        .replace("/", " ")
                        .replace("_", " ");
    }

    public static String getIp(){
        String ip="";
        try{
            ip=InetAddress.getLocalHost().getHostAddress();
        }catch(Exception e){
            System.out.println(e);
        }
        return ip;
    }

    public static String getDate(){
        return LocalDate.now().toString();
    }
}
