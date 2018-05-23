package RightPanel;

import Frame.MainFrame;
import Tools.ParentAvailablePanel;
import Tools.GBC;
import Tools.RCBorder;
import Tools.Colors;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Queue;

/**
 * 右侧聊天面板
 * <p>
 * Created by song on 17-5-30.
 */
public class ChatPanel extends ParentAvailablePanel
{
    private MessagePanel messagePanel;
    private MessageEditorPanel messageEditorPanel;
    private static ChatPanel context;
    public static String CHAT_ROOM_OPEN_ID = "";

    // APP启动时，已加载过远程未读消息的Rooms
    private static List<String> remoteHistoryLoadedRooms = new ArrayList<>();

    //private java.util.List<MessageItem> messageItems = new ArrayList<>();
    //private MessageAdapter adapter;
    //private CurrentUser currentUser;
    //private Room room; // 当前房间

    private long firstMessageTimestamp = 0L; // 如果是从消息搜索列表中进入房间的，这个属性不为0

    // 房间的用户
    public List<String> roomMembers = new ArrayList<>();

    //private MessageService messageService = Launcher.messageService;
    //private CurrentUserService currentUserService = Launcher.currentUserService;
    //private RoomService roomService = Launcher.roomService;
    //private ImageAttachmentService imageAttachmentService = Launcher.imageAttachmentService;
    //private FileAttachmentService fileAttachmentService = Launcher.fileAttachmentService;
    public static List<String> uploadingOrDownloadingFiles = new ArrayList<>();
    //private FileCache fileCache;


    // 每次加载的消息条数
    private static final int PAGE_LENGTH = 10;


    private String roomId;

    private Logger logger = Logger.getLogger(this.getClass());

    //private RemindUserPopup remindUserPopup = new RemindUserPopup();
    //private MessageViewHolderCacheHelper messageViewHolderCacheHelper;


    private static final int MAX_SHARE_ATTACHMENT_UPLOAD_COUNT = 1024;

    private Queue<String> shareAttachmentUploadQueue = new ArrayDeque<>(MAX_SHARE_ATTACHMENT_UPLOAD_COUNT);

    private JButton a;
    public ChatPanel(JPanel parent)
    {

        super(parent);
        context = this;
        //currentUser = currentUserService.findAll().get(0);
        //messageViewHolderCacheHelper = new MessageViewHolderCacheHelper();

        initComponents();
        initView();
        //setListeners();

        //initData();

        //fileCache = new FileCache();
    }

    private void initComponents()
    {

        messagePanel = new MessagePanel(this);
        messagePanel.setBorder(new RCBorder(RCBorder.BOTTOM, Colors.LIGHT_GRAY));
        //adapter = new MessageAdapter(messageItems, messagePanel.getMessageListView(), messageViewHolderCacheHelper);
        //messagePanel.getMessageListView().setAdapter(adapter);

        messageEditorPanel = new MessageEditorPanel(this);
        messageEditorPanel.setPreferredSize(new Dimension(MainFrame.DEFAULT_WIDTH, MainFrame.DEFAULT_WIDTH / 4));
    }


    private void initView()
    {
        this.setLayout(new GridBagLayout());
        add(messagePanel, new GBC(0, 0).setFill(GBC.BOTH).setWeight(1, 4));
        add(messageEditorPanel, new GBC(0, 1).setFill(GBC.BOTH).setWeight(1, 1));


        //messagePanel.setVisible(true);
        //messageEditorPanel.setVisible(false);
    }

    public static ChatPanel getContext()
    {
        return context;
    }


}
