package com.solarvalley.util;

import com.solarvalley.entities.User;

public class EmailUtil {

    public static String getMailBody(User user){
        return
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "    <meta charset='utf-8'>" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1'>" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
                        "    <style type='text/css'>" +
                        "        body, table, td, a {" +
                        "            font-family: 'Arial', sans-serif;" +
                        "            text-size-adjust: 100%;" +
                        "            line-height: 1.5;" +
                        "        }" +
                        "        img {" +
                        "            border: 0;" +
                        "            height: auto;" +
                        "            display: block;" +
                        "        }" +
                        "        table {" +
                        "            border-collapse: collapse;" +
                        "            width: 100%;" +
                        "        }" +
                        "        a {" +
                        "            text-decoration: none;" +
                        "            color: inherit;" +
                        "        }" +
                        "        .button {" +
                        "            display: inline-block;" +
                        "            padding: 15px 30px;" +
                        "            background-color: #F4C700;" +
                        "            color: #ffffff;" +
                        "            font-size: 16px;" +
                        "            font-weight: bold;" +
                        "            border-radius: 5px;" +
                        "            text-align: center;" +
                        "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);" +
                        "            transition: background-color 0.3s ease;" +
                        "        }" +
                        "        .button:hover {" +
                        "            background-color: #e0b800;" +
                        "        }" +
                        "        .header-section {" +
                        "            display: flex;" +
                        "            align-items: center;" +
                        "            justify-content: space-between;" +
                        "            background-color: #F4C700;" +
                        "            padding: 20px;" +
                        "            border-radius: 8px 8px 0 0;" +
                        "            flex-wrap: nowrap;" +
                        "        }" +
                        "        .header-section h2 {" +
                        "            color: #ffffff;" +
                        "            font-size: 24px;" +
                        "            margin: 0;" +
                        "            flex: 1;" +
                        "            word-wrap: break-word;" +
                        "        }" +
                        "        .header-logo {" +
                        "            max-width: 80px;" +
                        "            height: 80px;" +
                        "            margin-left: 20px;" +
                        "            flex-shrink: 0;" +
                        "        }" +
                        "        @media screen and (max-width: 525px) {" +
                        "            .header-section {" +
                        "                display: flex;" +
                        "                align-items: center;" +
                        "                justify-content: space-between;" +
                        "                flex-wrap: nowrap;" +
                        "            }" +
                        "            .header-section h2 {" +
                        "                font-size: 20px;" +
                        "            }" +
                        "            .header-logo {" +
                        "                max-width: 50px;" +
                        "            }" +
                        "        }" +
                        "    </style>" +
                        "</head>" +
                        "<body style='margin: 0; padding: 0; background-color: #f9f9f9;'>" +

                        "    <table>" +
                        "        <tr>" +
                        "            <td bgcolor='#ffffff' align='center' style='padding: 30px 20px;'>" +
                        "                <table class='wrapper' style='max-width: 600px; width: 100%; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);'>" +
                        "                    <tr>" +
                        "                        <td>" +
                        "                            <div class='header-section'>" +
                        "                                <h2>Thank You for Contacting Solar Valley!</h2>" +
                        "                                <img src='https://lh3.googleusercontent.com/p/AF1QipPgdkatiyQpGd_cLjCEDhgMZ79TdrtfDBgnRQOF=s2076-w768-h2076' alt='Solar Valley Logo' class='header-logo'>" +
                        "                            </div>" +
                        "                        </td>" +
                        "                    </tr>" +
                        "                    <tr>" +
                        "                        <td style='padding: 20px; text-align: left; font-size: 16px; color: #333333; background-color: #f4f4f4;'>" +
                        "                            <p style='margin: 0;'>Dear <strong>" + user.getFullName() + "</strong>,</p>" +
                        "                            <p style='margin-top: 10px;'>Thank you for reaching out to Solar Valley. We have received your inquiry, and our team will get back to you as soon as possible.</p>" +
                        "                            <p style='margin-top: 20px; font-style: italic; color: #7b7b7b;'>“Powering your future with sustainable solar solutions. Together, we make the world greener.”</p>" +
                        "                        </td>" +
                        "                    </tr>" +

                        "                    <tr>" +
                        "                        <td style='padding: 20px; text-align: left; font-size: 16px; color: #333333; background-color: #f9f9f9;'>" +
                        "                            <h3 style='color: #F4C700;'>Your Message:</h3>" +
                        "                            <p style='background-color: #ffffe0; padding: 10px; border-left: 5px solid #F4C700;'>" +
                        "                                <strong>Message: </strong>" + user.getMessage() + "</p>" +
                        "                        </td>" +
                        "                    </tr>" +

                        "                    <tr>" +
                        "                        <td style='padding: 20px; text-align: left; font-size: 16px; color: #333333; background-color: #ffffff;'>" +
                        "                            <h3 style='color: #F4C700;'>Your Details:</h3>" +
                        "                            <ul style='list-style-type: none; margin: 0; padding: 0;'>" +
                        "                                <li><strong>Full Name: </strong>" + user.getFullName() + "</li>" +
                        "                                <li><strong>Email ID: </strong>" + user.getEmail() + "</li>" +
                        "                                <li><strong>Phone Number: </strong>" + user.getPhoneNumber() + "</li>" +
                        "                            </ul>" +
                        "                        </td>" +
                        "                    </tr>" +

                        "                </table>" +

                        "                <table>" +
                        "                    <tr>" +
                        "                        <td bgcolor='#f9f9f9' align='center' style='padding: 20px 0;'>" +
                        "                            <table class='wrapper' style='max-width: 600px; width: 100%; text-align: center;'>" +
                        "                                <tr>" +
                        "                                    <td style='color: #7b7b7b; font-size: 14px; text-align: center;'>" +
                        "                                        <p style='margin: 0;'>Best Regards,</p>" +
                        "                                        <p style='margin: 5px 0;'>The Solar Valley Team</p>" +
                        "                                        <p style='margin: 10px 0; font-size: 12px; color: #999999;'>Note: This is an auto-generated email. Please do not reply.</p>" +
                        "                                    </td>" +
                        "                                </tr>" +
                        "                            </table>" +
                        "                        </td>" +
                        "                    </tr>" +
                        "                </table>" +

                        "</body>" +
                        "</html>";
    }

}
