package com.acctmq.activemqexample;

public class App 
{
    public static void main( String[] args )
    {
        new ObjectProducer().start();
        new ObjectConsumer().start();
    }
}
