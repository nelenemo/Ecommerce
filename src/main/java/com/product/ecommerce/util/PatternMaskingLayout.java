package com.product.ecommerce.util;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




@Component
public class PatternMaskingLayout extends PatternLayout {

    private Pattern usernamePattern;
    private List<String> maskPatterns = new ArrayList<>();

    //component to add masking in the logs

    public void addMaskPattern(String maskPattern) {
        maskPatterns.add(maskPattern);
        usernamePattern = Pattern.compile(String.join("|", maskPatterns),Pattern.MULTILINE);
    }
    //To call all the logs
    @Override
    public String doLayout(ILoggingEvent event) {
        return maskMessage(super.doLayout(event));
    }
    //Main logic of masking the logs
    private String maskMessage(String message) {
        //if null then message or logs is shown without masking
        if (usernamePattern == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(message);
        Matcher matcher = usernamePattern.matcher(sb);
        while (matcher.find()) {
            if (matcher.group().contains("productName")|| matcher.group().contains("productPrice")) {
                maskFieldData(sb, matcher);
            }
        }
        return sb.toString();
    }

    private void maskFieldData(StringBuilder sb, Matcher matcher) {
        String targetExpression = matcher.group();
        String[] split ;
        if (targetExpression.contains("=")) {
            split = targetExpression.split("=");
        } else {
            split = targetExpression.split(":");
        }
        if (split != null ) {
            String pan = split[1];
            String maskedPan= getMaskedPan(pan);
            int start= matcher.start()+split[0].length()+1;
            int end= matcher.end();
            sb.replace(start,end,maskedPan);

        }
    }
    //Replacing the message with masked message (*******)
    private String getMaskedPan(String pan) {
        pan= pan.replaceAll(pan,"*********");
        return pan;
    }
}

