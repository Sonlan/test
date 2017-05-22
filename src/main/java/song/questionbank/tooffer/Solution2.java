package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/3.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 消息中间件中有两个概念：消息和队列。
 队列可以理解为消息的载体，生产者（Producer）将消息发送到队列中，消费者（Consumer）从队列中消费消息，同一个队列的消息只会被一个消费者按序消费，不同队列的消息不保证消费顺序。
 消息又分为顺序消息和乱序消息，在很多业务中，产生的消息需要保证一定程度上的按序消费，将这类消息按一定的规则发送到同一个队列里即可保证消息的有序性。

 随着业务的发展，消息系统需要对队列数进行扩容，为了实现不停机的扩容方式，且保证消息在扩容过程中不会乱序，约定扩容时需要按当前队列的倍数进行扩容。因为大多数情况下，消息消费的速度慢于生产的速度，为了保证扩容过程的消息有序性约定：在t时刻新扩容的队列可以立马接收消息，但必须等旧队列上在t时刻前接收到的消息被全部消费完毕后才可以被消费者进行消费。

 消费者在消费的过程中，通过消费位点来记录或者控制消费速度，比如当前某队列上堆积了5条消息，最开始消费位点为0，当有三条消息被消费后，消费位点则变成了3。
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }
    public static void main(String [] args){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.replaceSpace(new StringBuffer("I am a good boy")));
    }
}
