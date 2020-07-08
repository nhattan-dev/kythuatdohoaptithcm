/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object2D;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Welcome
 */
public class Draw2D {

    private BufferedImage img;

    public Draw2D(BufferedImage img) {
        this.img = img;
    }

    public BufferedImage drawLine(Point startPoint, Point endPoint, Color color) {
        //luôn vẽ từ trái sang phải
        if (startPoint.x > endPoint.x) {
            Point temp = startPoint;
            startPoint = endPoint;
            endPoint = temp;
        }
        int Dy, Dx, x, y, p;
        Dy = endPoint.y - startPoint.y;
        Dx = endPoint.x - startPoint.x;
        y = startPoint.y;
        x = startPoint.x;
        try {
            //Ve diem pixel dau tien
            img.setRGB(x, y, color.getRGB());
        } catch (Exception e) {
        }
        if (Math.abs(Dx) < Math.abs(Dy)) {
            if (startPoint.y > endPoint.y) {
                //A
                p = 2 * Dx + Dy;
                while (y > endPoint.y) {
                    if (p >= 0) {
                        p += (2 * Dx + 2 * Dy);
                        x++;
                    } else {
                        p += (2 * Dx);
                    }
                    //Point conditions
                    try {
                        img.setRGB(x, y, color.getRGB());
                    } catch (Exception e) {
                    }
                    y--;
                }
            } else {
                //D
                p = 2 * Dx - Dy;
                while (y < endPoint.y) {
                    if (p < 0) {
                        p += (2 * Dx);
                    } else {
                        p += (2 * Dx - 2 * Dy);
                        x++;
                    }
                    //Point conditions
                    try {
                        img.setRGB(x, y, color.getRGB());
                    } catch (Exception e) {
                    }
                    y++;
                }
            }
        } else {
            if (startPoint.y > endPoint.y) {
                //B
                p = 2 * Dy + Dx;
                while (x < endPoint.x) {
                    if (p <= 0) {
                        p += (2 * Dx + 2 * Dy);
                        y--;
                    } else {
                        p += (2 * Dy);
                    }
                    //Point conditions
                    try {
                        img.setRGB(x, y, color.getRGB());
                    } catch (Exception e) {
                    }
                    x++;
                }
            } else {
                //C
                p = 2 * Dy - Dx;
                while (x < endPoint.x) {
                    if (p < 0) {
                        p += (2 * Dy);
                    } else {
                        p += (2 * Dy - 2 * Dx);
                        y++;
                    }
                    //Point conditions
                    try {
                        img.setRGB(x, y, color.getRGB());
                    } catch (Exception e) {
                    }
                    x++;
                }
            }
        }
        return img;
    }

    private boolean isDashed(int value) {
        int sodu = value % 25;
        return ((sodu != 0) && sodu <= 15);
    }

    public BufferedImage Dashed(Point startPoint, Point endPoint, Color color) {
        if (startPoint.x > endPoint.x) {
            Point temp = startPoint;
            startPoint = endPoint;
            endPoint = temp;
        }
        int Dy, Dx, pi, x, y, p;
        Dy = endPoint.y - startPoint.y;
        Dx = endPoint.x - startPoint.x;
        y = startPoint.y;
        x = startPoint.x;
        try {
            img.setRGB(x, y, color.getRGB()); //Ve diem pixel dau tien
        } catch (Exception e) {
        }
        if (Math.abs(Dx) < Math.abs(Dy)) {
            if (startPoint.y > endPoint.y) {
                //A
                p = 2 * Dx + Dy;
                while (y > endPoint.y) {
                    if (p >= 0) {
                        p += (2 * Dx + 2 * Dy);
                        x++;
                    } else {
                        p += (2 * Dx);
                    }
                    if (isDashed(y)) {
                        try {
                            img.setRGB(x, y, color.getRGB());
                        } catch (Exception e) {
                        }
                    }
                    y--;
                }
            } else {
                //D
                p = 2 * Dx - Dy;
                while (y < endPoint.y) {
                    if (p < 0) {
                        p += (2 * Dx);
                    } else {
                        p += (2 * Dx - 2 * Dy);
                        x++;
                    }
                    if (isDashed(y)) {
                        try {
                            img.setRGB(x, y, color.getRGB());
                        } catch (Exception e) {
                        }
                    }
                    y++;
                }
            }
        } else {
            if (startPoint.y > endPoint.y) {
                //B
                p = 2 * Dy + Dx;
                while (x < endPoint.x) {
                    if (p <= 0) {
                        p += (2 * Dx + 2 * Dy);
                        y--;
                    } else {
                        p += (2 * Dy);
                    }
                    if (isDashed(x)) {
                        try {
                            img.setRGB(x, y, color.getRGB());
                        } catch (Exception e) {
                        }
                    }
                    x++;
                }
            } else {
                //C
                p = 2 * Dy - Dx;
                while (x < endPoint.x) {
                    if (p < 0) {
                        p += (2 * Dy);
                    } else {
                        p += (2 * Dy - 2 * Dx);
                        y++;
                    }
                    if (isDashed(x)) {
                        try {
                            img.setRGB(x, y, color.getRGB());
                        } catch (Exception e) {
                        }
                    }
                    x++;
                }
            }
        }
        return img;
    }

    public int soDu(int poss, int R, int value) {
        return (int) ((value + 1) + poss * R * Math.sqrt(2) / 2);
    }

    public void setColor(Point startPoint, int x, int y, Color color, int R, int key) {
        // 2 vẽ 2 trống = 4*5ratio
        int ratio = 5;
        int visible = 2 * ratio;
        int hide = 2 * ratio;
        int points = (int) Math.ceil(R * Math.sqrt(2) / 2);
        int sum = visible + hide;

        try {
            img.setRGB(x + startPoint.x, y + startPoint.y, color.getRGB());
        } catch (Exception e) {
        }

        try {
            img.setRGB(y + startPoint.x, x + startPoint.y, color.getRGB());
        } catch (Exception e) {
        }

        int sodu2 = (int) ((x + 2 * points - 1) % sum);
        if (sodu2 < visible || key == 1) {
            try {
                img.setRGB(y + startPoint.x, -x + startPoint.y, color.getRGB());
            } catch (Exception e) {
            }
        }

        int sodu3 = (int) ((-x + 4 * points - 2) % sum);
        if (sodu3 < visible || key == 1) {
            try {
                img.setRGB(x + startPoint.x, -y + startPoint.y, color.getRGB());
            } catch (Exception e) {
            }
        }

        int sodu4 = (int) ((x + 4 * points - 2) % sum);
        if (sodu4 < visible || key == 1) {
            try {
                img.setRGB(-x + startPoint.x, -y + startPoint.y, color.getRGB());
            } catch (Exception e) {

            }
        }

        int sodu5 = (int) ((-x + 6 * points - 3) % sum);
        if (sodu5 < visible || key == 1) {
            try {
                img.setRGB(-y + startPoint.x, -x + startPoint.y, color.getRGB());
            } catch (Exception e) {
            }
        }

        try {
            img.setRGB(-y + startPoint.x, x + startPoint.y, color.getRGB());
        } catch (Exception e) {
        }

        try {
            img.setRGB(-x + startPoint.x, y + startPoint.y, color.getRGB());
        } catch (Exception e) {
        }
    }

    //2 50-50
    public BufferedImage drawCircle(Point startPoint, int R, Color color, int key) {
        int x = 0, y = (int) R, p = Math.round(5 / 4 - R);
        setColor(startPoint, x, y, color, R, key);
        while (x < (Math.sqrt(2) * R) / 2) {
            if (p < 0) {
                p += 2 * x + 3;
            } else {
                p += 2 * x - 2 * y + 5;
                y--;
            }
            x++;
            setColor(startPoint, x, y, color, R, key);
        }
        return img;
    }

    public BufferedImage drawRect(Point start, Point end, Color color) {
        int x1, x2, y1, y2;
        if (start.x > end.x) {
            x1 = end.x;
            x2 = start.x;
        } else {
            x1 = start.x;
            x2 = end.x;
        }
        if (start.y > end.y) {
            y1 = end.y;
            y2 = start.y;
        } else {
            y1 = start.y;
            y2 = end.y;
        }

        Point startPoint = new Point(x1, y1);
        Point endPoint = new Point(x2, y2);
        Point C = new Point(endPoint.x, startPoint.y);
        Point D = new Point(startPoint.x, endPoint.y); 

        img = drawLine(startPoint, C, color);
        img = drawLine(startPoint, D, color);
        img = drawLine(endPoint, C, color);
        img = drawLine(endPoint, D, color);

        return img;
    }
}
