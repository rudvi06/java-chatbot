package com.ecommerce.mvc.services;

import org.alicebot.ab.*;
import org.alicebot.ab.configuration.BotConfiguration;
import org.alicebot.ab.utils.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ChatBotService {

    public static void chatBot(String text) {
        try {

            Bot bot = new Bot(BotConfiguration.builder()
                    .name("test")
                    .path(getResourcesPath())
                    .build());

            Chat chatSession = new Chat(bot);

            //String botname = "test";
            //String path = getResourcesPath();
            //MagicBooleans.trace_mode = false;
            //Bot bot = new Bot(botname, path);

            //chatSession = new Chat(bot);
            String textLine = "";

            while (true) {
                System.out.print("Human : ");
                //textLine = IOUtils.readInputTextLine();
                textLine = text;
                if ((textLine == null) || (textLine.length() < 1))
                    //textLine = MagicStrings.null_input;
                    textLine ="";
                else {
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
        String resourcesPath = path + File.separator+ "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }

}
