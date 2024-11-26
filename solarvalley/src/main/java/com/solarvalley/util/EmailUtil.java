package com.solarvalley.util;

import com.solarvalley.entities.User;

public class EmailUtil {

    public static String getMailBody(User user){
        String emailBody = "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                "<style type=\"text/css\">" +
                "body, table, td, a {" +
                "font-family: 'Arial', sans-serif;" +
                "text-size-adjust: 100%;" +
                "line-height: 1.5;" +
                "}" +
                "img {" +
                "border: 0;" +
                "height: auto;" +
                "display: block;" +
                "font-family: Arial, sans-serif;" +
                "}" +
                "table {" +
                "border-collapse: collapse;" +
                "width: 100%;" +
                "}" +
                "a {" +
                "text-decoration: none;" +
                "color: inherit;" +
                "}" +
                ".button {" +
                "display: inline-block;" +
                "padding: 15px 30px;" +
                "background-color: #F4C700;" +  // Yellow theme
                "color: #ffffff;" +
                "font-size: 16px;" +
                "font-weight: bold;" +
                "border-radius: 5px;" +
                "text-align: center;" +
                "box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" +
                "transition: background-color 0.3s ease;" +
                "}" +
                ".button:hover {" +
                "background-color: #e0b800;" +  // Darker yellow for hover
                "}" +
                ".button-container {" +
                "text-align: center;" +
                "padding: 20px;" +
                "}" +
                "@media screen and (max-width: 525px) {" +
                ".wrapper {" +
                "width: 100% !important;" +
                "max-width: 100% !important;" +
                "}" +
                ".logo img {" +
                "max-width: 80% !important;" +
                "margin: 0 auto !important;" +
                "}" +
                ".mobile-hide {" +
                "display: none !important;" +
                "}" +
                ".img-max {" +
                "width: 100% !important;" +
                "height: auto !important;" +
                "}" +
                ".responsive-table {" +
                "width: 100% !important;" +
                "}" +
                ".padding {" +
                "padding: 10px 5% 15px 5% !important;" +
                "}" +
                ".button-container {" +
                "width: 100% !important;" +
                "text-align: center !important;" +
                "padding: 20px 0;" +
                "}" +
                ".button {" +
                "width: 100% !important;" +
                "padding: 15px 0 !important;" +
                "display: block !important;" +
                "}" +
                "}" +
                "</style>" +
                "</head>" +
                "<body style=\"margin: 0; padding: 0; background-color: #f9f9f9;\">" +

                "<table>" +
                "<tr>" +
                "<td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 0;\">" +
                "<table class=\"wrapper\" style=\"max-width: 600px; width: 100%;\">" +
                "<tr>" +
                "<td align=\"center\" class=\"logo\">" +
                "<a href=\"#\">" +
                "<img src=\"https://your-logo-path.png\" alt=\"Solar Valley Logo\" width=\"150\">" +
                "</a>" +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</td>" +
                "</tr>" +
                "</table>" +

                "<table>" +
                "<tr>" +
                "<td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 30px 20px;\">" +
                "<table class=\"wrapper\" style=\"max-width: 600px; width: 100%; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);\">" +
                "<tr>" +
                "<td style=\"padding: 20px; text-align: center; background-color: #F4C700; border-radius: 8px 8px 0 0;\">" +  // Yellow theme
                "<h2 style=\"color: #ffffff; font-size: 24px; margin: 0;\">Thank You for Contacting Solar Valley!</h2>" +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td style=\"padding: 20px; text-align: left; font-size: 16px; color: #333333; background-color: #f4f4f4;\">" +
                "<p style=\"margin: 0;\">Dear <strong>"+user.getFullName()+"</strong>,</p>" +
                "<p style=\"margin-top: 10px;\">Thank you for reaching out to Solar Valley. We have received your inquiry, and our team will get back to you as soon as possible.</p>" +
                "<p style=\"margin-top: 20px; font-style: italic; color: #7b7b7b;\">“Powering your future with sustainable solar solutions. Together, we make the world greener.”</p>" +
                "</td>" +
                "</tr>" +

                "<tr>" +
                "<td style=\"padding: 20px; text-align: left; font-size: 16px; color: #333333; background-color: #f9f9f9;\">" +
                "<h3 style=\"color: #F4C700;\">Your Message:</h3>" +  // Title for message section in yellow
                "<p style=\"background-color: #ffffe0; padding: 10px; border-left: 5px solid #F4C700;\">" +  // Light yellow background for message
                "<strong>Message: </strong>" + user.getMessage() + "</p>" +
                "</td>" +
                "</tr>" +

                "</table>" +

                "<table>" +
                "<tr>" +
                "<td bgcolor=\"#f9f9f9\" align=\"center\" style=\"padding: 20px 0;\">" +
                "<table class=\"wrapper\" style=\"max-width: 600px; width: 100%; text-align: center;\">" +
                "<tr>" +
                "<td style=\"color: #7b7b7b; font-size: 14px; text-align: center;\">" +
                "<p style=\"margin: 0;\">Best Regards,</p>" +
                "<p style=\"margin: 5px 0;\">The Solar Valley Team</p>" +
                "<p style=\"margin: 10px 0; font-size: 12px; color: #999999;\">Note: This is an auto-generated email. Please do not reply.</p>" +
                "</td>" +
                "</tr>" +
                "</table>" +
                "</td>" +
                "</tr>" +
                "</table>" +

                "</body>" +
                "</html>";
        return emailBody;
    }

}
