package dungeonCrawler;

public class Logger {
    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_GREY = "\u001B[37m";

    public static final String ANSI_MAGENT = "\u001B[35m";

    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_BACK_CYAN = "\u001B[44m";

    public static final String ANSI_BACK_GREEN = "\u001B[42m";

    public static final String ANSI_BACK_MAGENT = "\u001B[45m";

    public static final String ANSI_RESET = "\u001B[0m";

    private static final Logger instance = new Logger();

    public static Logger getInstance() {
        return instance;
    }

    public void blue(String message) {

        log(message, ANSI_BLUE);
    }

    public void green(String message) {
        log(message, ANSI_GREEN);
    }

    public void red(String message) {
        log(message, ANSI_RED);
    }

    public void yellow(String message) {
        log(message, ANSI_YELLOW);
    }

    public void grey (String message) {
        log(message, ANSI_GREY);
    }

    public void magent (String message) {
        log(message, ANSI_MAGENT);
    }

    public void cyan (String message) {
        log(message, ANSI_CYAN);
    }

    public void black (String message) {
        log(message, ANSI_BLACK);
    }

    public void backCyan (String message) {
        log(message, ANSI_BACK_CYAN);
    }

    public void backGreen (String message) {
        log(message, ANSI_BACK_GREEN);
    }

    public void backMagent (String message) {
        log(message, ANSI_BACK_MAGENT);
    }

    public void log(String message, String colore){
        System.out.println(colore + message + ANSI_RESET);
    }

}
