package com.grpc.client;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MainClient {


    private static final Logger logger = LoggerFactory.getLogger(MainClient.class);

    public static void main(String[] args)  {
        MainClient c = new MainClient();
        c.readCLI(args);

    }

    public void readCLI(String[] args) {
        Options options = new Options();

        Option concurrentUsersNumber = new Option("u", "usersNumber", true, "Number of concurrent users emulated");
        concurrentUsersNumber.setRequired(true);
        options.addOption(concurrentUsersNumber);

        Option requestNumber = new Option("c", "requestNumber", true, "Number of concurrent requests a user will make");
        requestNumber.setRequired(true);
        options.addOption(requestNumber);

        Option rounds = new Option("r", "roundsNumber", true, "Number of rounds each thread is executing");
        rounds.setRequired(true);
        options.addOption(rounds);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            logger.info(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        int concurrentUsersNumberInput = Integer.valueOf(cmd.getOptionValue("usersNumber"));
        int requestNumberInput = Integer.valueOf(cmd.getOptionValue("requestNumber"));
        int roundsInput = Integer.valueOf(cmd.getOptionValue("roundsNumber"));


        int numPermission = 100;
        Semaphore semaphore = new Semaphore(numPermission);
        ManagedChannel channel  = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext(true).build();


        WalletClientRunnable[] process = new WalletClientRunnable[requestNumberInput];
        //Simulate an number of users.
        for (int userId = 0; userId < concurrentUsersNumberInput; userId++) {
            //Number of threads.
            for (int i = 0; i < requestNumberInput; i++) {
                process[i] = new WalletClientRunnable(i, semaphore, userId, channel, roundsInput);
                process[i].start();
            }
        }

    }
}
