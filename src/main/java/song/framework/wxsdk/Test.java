package song.framework.wxsdk;

import com.song.wxsdk.WxSDK;
import com.song.wxsdk.apis.msg.uplink.TemplateMsg;
import com.song.wxsdk.apis.msg.uplink.TextMsg;


/**
 * Created by Song on 2017/6/26.
 */
public class Test {
    public static void main(String [] args) throws Exception{
            WxSDK.init();
            WxSDK.MSG_SDK.send(new TextMsg("obGURwbzfKF2SWtjDuPtODOGJlSg",
                    "hellow slanf"));
            TemplateMsg templateMsg = new TemplateMsg(
                    "obGURwbzfKF2SWtjDuPtODOGJlSg",
                    "5Lf7xnN-daeG1pE7yKMd8TzivLj-bYNvCCk65zq1n8s",
                    "www.baidu.com"
            );
            templateMsg.addPair("title","测试消息");
            templateMsg.addPair("keyword1","随心而笑");
            templateMsg.addPair("keyword2","一等奖");
            WxSDK.MSG_SDK.send(templateMsg);
    }
}
