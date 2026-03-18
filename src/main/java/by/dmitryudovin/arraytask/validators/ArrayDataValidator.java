package by.dmitryudovin.arraytask.validators;

import java.util.regex.Pattern;

public class ArrayDataValidator implements PersonalValidator {
    private static final Pattern SEPARATORS = Pattern.compile("[\\s,;–]+");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    private final String line;
    private String type;
    private String[] cleanTokens;

    public ArrayDataValidator(String line) {
        this.line = line.trim();
    }

    @Override
    public boolean isValid() {
        if (line.isEmpty()) {
            return false;
        }

        String[] tokens = SEPARATORS.split(line);
        if (tokens.length == 0) return false;

        type = detectType(tokens);
        if (type == null) return false;

        cleanTokens = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            if (!isValidToken(tokens[i], type)) {
                return false;
            }
            cleanTokens[i] = tokens[i];
        }
        return true;
    }

    private String detectType(String[] tokens) {
        for (String token : tokens) {
            if (INTEGER_PATTERN.matcher(token).matches()) return "INTEGER";
            if (DOUBLE_PATTERN.matcher(token).matches()) return "DOUBLE";
        }
        return null;
    }

    private boolean isValidToken(String token, String type) {
        return switch (type) {
            case "INTEGER" -> INTEGER_PATTERN.matcher(token).matches();
            case "DOUBLE" -> DOUBLE_PATTERN.matcher(token).matches();
            default -> false;
        };
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getLength() {
        return (cleanTokens != null ? cleanTokens.length : 0);
    }

    public String[] getTokens() {
        return cleanTokens;
    }

}
