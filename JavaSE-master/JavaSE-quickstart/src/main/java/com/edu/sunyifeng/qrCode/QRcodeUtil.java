package com.edu.sunyifeng.qrCode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import java.awt.*;


public class QRcodeUtil {

    public static void generateQrcode() {
        // 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
    }

    public static void generateQrcode1() {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        // 生成二维码到文件，也可以到流
        QrCodeUtil.generate("http://hutool.cn/", config, FileUtil.file("d:/qrcode.jpg"));
    }

    public static void generateQrcode2() {
        QrCodeUtil.generate(//
                "http://m.qpic.cn/psc?/V141IQYQ4Jehl6/lpoTnOcKgshCRzVbSpUVWc4f9w2PIreKa5nOWjQ29YkJe1HyV4cYpUrYyVPIUkKAgrdwQw7Xfc3*l0TZU15vVAya9EJVC*aMJ7C3v4GpOpA!/b&bo=FwIABAAAAAADR3M!&rf=viewer_4&t=5", //二维码内容
                QrConfig.create().setImg("d:/6429.jpg"), //附带logo
                FileUtil.file("d:/qrcode.jpg")//写出到的文件
        );
    }


    public static void main(String[] args) {
        // generateQrcode();
        // generateQrcode1();
        generateQrcode2();

    }

}
