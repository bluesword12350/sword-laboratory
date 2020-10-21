package top.bluesword.java.nio.file;

import java.io.IOException;
import java.nio.file.*;

class WatchServiceTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("target/test");
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.OVERFLOW);
        for (int i = 0; i < 100000; i++) {
            WatchKey watchKey = watchService.take();
            for (WatchEvent<?> pollEvent : watchKey.pollEvents()) {
                String pathName = pollEvent.context().toString();
                String name = pollEvent.kind().name();
                if (name.equals(StandardWatchEventKinds.ENTRY_CREATE.name())) {
                    System.out.println("创建了一个文件：" + pathName);
                } else if (name.equals(StandardWatchEventKinds.ENTRY_DELETE.name())) {
                    System.out.println("删除了一个文件：" + pathName);
                } else if (name.equals(StandardWatchEventKinds.ENTRY_MODIFY.name())) {
                    System.out.println("修改了一个文件：" + pathName);
                } else if (name.equals(StandardWatchEventKinds.OVERFLOW.name())) {
                    System.out.println("覆盖了一个文件：" + pathName);
                } else {
                    System.out.println("未知操作：" + name);
                }
            }
            watchKey.reset();
        }
    }

}
