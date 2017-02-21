package me.pzzls;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C) 2017 mosl, Inc.
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 *
 * @author <a href="mailto:moshenglei@icloud.com">mosl</a>
 * @since 2017/2/21 下午6:47
 */
public class WebApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApp.class);

    private static final int DEFAULT_SERVER_PORT = 8089;

    public static void main(String[] args) {
        int port = getServerPort(args);

        Server server = new Server(port);

        WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Throwable t) {
            LOGGER.error("start server error", t);
            System.exit(-1);
        }
    }

    private static int getServerPort(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                LOGGER.error("invalid server port argument: {}", args[0]);
            }
        }

        return DEFAULT_SERVER_PORT;
    }
}
