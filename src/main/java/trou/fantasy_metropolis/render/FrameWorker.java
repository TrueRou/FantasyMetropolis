package trou.fantasy_metropolis.render;

import net.minecraft.ChatFormatting;

import java.util.Arrays;
import java.util.List;

public class FrameWorker {
    public static float renderTimer = 0;

    private static final List<ChatFormatting> colorCodes = Arrays.asList(
            ChatFormatting.DARK_GRAY,
            ChatFormatting.DARK_PURPLE,
            ChatFormatting.LIGHT_PURPLE,
            ChatFormatting.AQUA,
            ChatFormatting.BLUE,
            ChatFormatting.DARK_AQUA,
            ChatFormatting.DARK_BLUE
    );

    public static float increaseTimer(float value) {
        return renderTimer += value;
    }

    public static void resetTimer() {
        renderTimer = 0;
    }

    public static String marquee(String targetString, boolean bold) {
        var renderTick = (int) renderTimer;
        int colorCodeIndex = renderTick % colorCodes.size();

        char[] charArray = targetString.toCharArray();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = targetString.charAt(i);

            String colorCode = "" + colorCodes.get((i + colorCodeIndex) % colorCodes.size()) + (bold ? ChatFormatting.BOLD : "");
            string.append(colorCode).append(currentChar);
        }

        return string.toString();
    }
}
