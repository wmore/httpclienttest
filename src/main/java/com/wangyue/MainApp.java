package com.wangyue;

import com.wangyue.manager.DataManager;
import com.wangyue.manager.DataManagerByHTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = {"com"})
public class MainApp implements CommandLineRunner {

    @Autowired
    private DataManagerByHTTP dataManager;
//    private DataManager dataManager;

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            while (true) {
                System.out.println("请选择(Y开始同步数据、N退出):");

                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("N")) {
                    System.out.println("程序退出..");
                    return;
                }
                if (input.equalsIgnoreCase("Y")) {
                    System.out.println("开始同步数据..");
                    dataManager.syncData();
                    return;
                }
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }
}
