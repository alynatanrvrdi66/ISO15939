import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class RadarChartPanel extends JPanel {

    private String[] labels;
    private double[] scores;

    public RadarChartPanel() {

        labels = new String[] {
                "Usability",
                "Reliability",
                "Performance",
                "Accessibility",
                "Security"
        };

        scores = new double[] {
                4.5,
                3.2,
                4.0,
                4.7,
                3.8
        };

        setPreferredSize(
                new java.awt.Dimension(450, 450)
        );
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int radius = 150;

        int count = labels.length;

        for(int i = 0; i < count; i++) {

            double angle =
                    Math.toRadians(
                            -90 + (360.0 / count) * i
                    );

            int x =
                    centerX +
                            (int)(Math.cos(angle) * radius);

            int y =
                    centerY +
                            (int)(Math.sin(angle) * radius);

            g2.drawLine(centerX, centerY, x, y);

            g2.drawString(labels[i], x - 25, y);
        }

        Path2D polygon =
                new Path2D.Double();

        for(int i = 0; i < count; i++) {

            double angle =
                    Math.toRadians(
                            -90 + (360.0 / count) * i
                    );

            double scaledRadius =
                    (scores[i] / 5.0) * radius;

            int x =
                    centerX +
                            (int)(Math.cos(angle) * scaledRadius);

            int y =
                    centerY +
                            (int)(Math.sin(angle) * scaledRadius);

            if(i == 0)
                polygon.moveTo(x, y);
            else
                polygon.lineTo(x, y);
        }

        polygon.closePath();

        g2.setColor(
                new Color(0,120,255,120)
        );

        g2.fill(polygon);

        g2.setColor(Color.BLUE);

        g2.draw(polygon);
    }
}