import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

//实现验证码
@WebServlet("/GenerateCodeServlet")
public class GenerateCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random rand = new Random();
        int weight = 120;
        int height = 35;
        HttpSession session = req.getSession();
        //建立透明画布
        BufferedImage img = new BufferedImage(weight, height, 2);

        //建立画笔
        Graphics2D d = img.createGraphics();
        //设置线条和文件的，抗锯齿（平滑）
        d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        //为画布增加边框先线条
        d.drawRect(0, 0, weight - 1, height - 1);
        //向建立的画布中添加字符串
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int len = 4;
        StringBuilder su = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int x = i * 25 + 20;
            int y = 25;
            //设置字体及大小
            Font font = new Font("宋体", Font.BOLD, 30);
            d.setFont(font);
            //随机文字和随机颜色
            d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), rand.nextInt(100) + 100));
            String t = String.valueOf(s.charAt(rand.nextInt(s.length())));
            //旋转
            su.append(t);
           /* double radianPercent = Math.PI * (rand.nextInt(35) / 180D);
            if (rand.nextBoolean()) {
                radianPercent = -radianPercent;
            }
            d.rotate(radianPercent, x, y);
            d.drawString(t, x, y);
            d.rotate(-radianPercent, x, y);*/
            d.drawString(t, x, y);
        }

        //在控制台打印输出索生成的验证码
        System.out.println(su);
        session.setAttribute("code",su);
        //添加干扰文字
        for (int i = 0; i <50 ; i++) {
            String j =String.valueOf(s.charAt(rand.nextInt(s.length())));
            d.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(50)+50));
            d.setFont(new Font("",Font.BOLD,10));
            int x = rand.nextInt(160);
            int y = rand.nextInt(35);
            d.drawString(j,x,y);

        }
        //添加干扰图像
        for (int i = 0; i <30 ; i++) {
            d.setColor(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(50)+50));
            int x = rand.nextInt(160);
            int y = rand.nextInt(35);
            d.fillOval(x,y, rand.nextInt(10)+10, rand.nextInt(10+10));

        }
        ServletOutputStream stream = resp.getOutputStream();

        //输出图片
        try {
            ImageIO.write(img, "png", new File("D:/checkNum.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将图片中的字节数据输入到in中
        FileInputStream in = new FileInputStream("D:/checkNum.png");
        //创建ServletOutputStream
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int l = 0 ;
        //循环将图片的字节，并输入到页面
        while ((l = in.read(bytes)) !=-1){
            outputStream.write(bytes , 0,l);
        }
        //关闭资源
        in.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
