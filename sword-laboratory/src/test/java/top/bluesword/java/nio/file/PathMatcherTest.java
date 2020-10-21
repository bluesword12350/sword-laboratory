package top.bluesword.java.nio.file;

import org.junit.jupiter.api.Test;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

class PathMatcherTest {

	@Test
	void matches() {
		String glob = "glob:/a/*";
		FileSystem fileSystem = FileSystems.getDefault();
		PathMatcher pathMatcher = fileSystem.getPathMatcher(glob);
		Path path = fileSystem.getPath("/a/55/5");
		System.out.println(path);
		System.out.println(pathMatcher.matches(path));
	}

}
