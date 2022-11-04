package com.ecommerce.mvc.services;

import org.alicebot.ab.*;
import org.alicebot.ab.utils.IOUtils;

import java.io.File;

public class ChatBotService {

    public static void main(String[] args) {
        try {

            String botname="test";
            String path=getResourcesPath();
            MagicBooleans.trace_mode = false;
            Bot bot = new Bot(botname, path);

            Chat chatSession = new Chat(bot);
            String textLine = "";

            while (true) {
                System.out.print("Human : ");
                textLine = IOUtils.readInputTextLine();
                if ((textLine == null) || (textLine.length() < 1))
                    textLine = MagicStrings.null_input;
                if (textLine.equals("q")) {
                    System.exit(0);
                } else if (textLine.equals("wq")) {
                    bot.writeQuit();
                    System.exit(0);
                } else {
                    String request = textLine;
                    String response = chatSession.multisentenceRespond(request);
                    while (response.contains("&lt;"))
                        response = response.replace("&lt;", "<");
                    while (response.contains("&gt;"))
                        response = response.replace("&gt;", ">");
                    System.out.println("Robot : " + response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + "/"+ "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }

}
