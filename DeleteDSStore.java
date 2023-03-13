import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteDSStore extends JPanel {
    public static void main(String[] args) {
        /**
         * 第一个反应，新建一个JFrame窗口
         * */
        JFrame frame = new JFrame("Delete DS_Store");

        /**
         * 设置窗口大小
         * */
        frame.setSize(300,100);

        /**
         * 设置JFrame窗口最大化
         *frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         */

        /**
         * 设置窗口位置居中，true则居中，false则不居中显示
         * */
        frame.setLocationRelativeTo(null);

        /**
         * 窗口关闭，及时关闭程序
         * */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * 第二步，把要放到JFrame窗口上的元素放到容器中
         * */
        JPanel panel =new JPanel();

        /**
         * 容器中添加一个标题
         * */
        JLabel title =new JLabel("DS_Store Delete Tool");
        panel.add(title);

        /**
         * 给我们的容器添加一个button按钮
         * */
        JButton button =new JButton("Start Delete");
        panel.add(button);

        /**
         * 将panel容器放到frame窗口里
         * */
        frame.add(panel);

        /**
         * 让框架可见
         * */
        frame.setVisible(true);

        /**
         * 当我们按下按钮，释放事件就触发
         * */
        button.addActionListener(e -> {

            /**
             * “小程序”的核心部分
             * */
            File folder = new File("/private/var/");
            File[] list_file = folder.listFiles();
            for (int i = 0; i < list_file.length; i++) {
                if (list_file[i].isFile()) {
                    String f_name = list_file[i].getName();
                    if (f_name.equals(".DS_Store")) {
                        list_file[i].delete();
                    }
                }
            }
            /**
             * 删除成功后，弹出对话框提示成功
             * */
            JOptionPane.showMessageDialog(frame,"Delete DS_Store Successfully!");
        });
    }
}
