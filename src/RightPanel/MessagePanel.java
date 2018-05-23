package RightPanel;

import Tools.ParentAvailablePanel;
import Tools.Colors;
import Tools.RCListView;
import javax.swing.*;
import java.awt.*;

/**
 * Created by song on 17-5-30.
 */
public class MessagePanel extends ParentAvailablePanel
{
    RCListView listView;
    private JButton a;
    public MessagePanel(JPanel parent)
    {
        super(parent);

        initComponents();
        setListeners();
        initView();
    }


    private void initComponents()
    {
        a =new JButton("xxxxxxx");
        listView = new RCListView(0, 15);
        listView.setScrollBarColor(Colors.WINDOW_BACKGROUND, Colors.WINDOW_BACKGROUND);
        listView.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        listView.setScrollHiddenOnMouseLeave(listView);

    }

    private void setListeners()
    {
        /*listView.addMouseListener(new AbstractMouseListener(){

            @Override
            public void mouseClicked(MouseEvent e)
            {
                RoomMembersPanel.getContext().setVisible(false);
                super.mouseClicked(e);
            }
        });*/
    }

    private void initView()
    {
        this.setLayout(new BorderLayout());
        add(listView, BorderLayout.CENTER);

        listView.repaint();
        listView.setVisible(true);


        /*addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                listView.repaint();
            }
        });*/
    }

    public RCListView getMessageListView()
    {
        return listView;
    }
}
