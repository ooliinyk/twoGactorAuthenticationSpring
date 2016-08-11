package app.authorization.twilio;

import com.twilio.sdk.Twilio;
import com.twilio.sdk.creator.api.v2010.account.MessageCreator;
import com.twilio.sdk.resource.api.v2010.account.Message;
import com.twilio.sdk.type.PhoneNumber;

/**
 * Created by user on 08.08.2016.
 */
public class SendSMS_Twilio {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC4e621ae8ec0817276cc9ff117821ca2f";
    public static final String AUTH_TOKEN = "366dc39a795c21bd94d57b2b7debb7db";
    public static final String MY_MOB = "+12018066232";

    public static void sendSMS(String sms, String mobile){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = new MessageCreator(
                ACCOUNT_SID,
                new PhoneNumber(mobile), // TO number
                new PhoneNumber(MY_MOB), // From Twilio number
                sms
        ).execute();
        System.out.println("Sms was sent");
    }



}
