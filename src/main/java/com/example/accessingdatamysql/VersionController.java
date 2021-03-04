package com.example.accessingdatamysql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {

	private VersionInfo versionInfo = new VersionInfo();

	@GetMapping
	public VersionInfo about() {
		return versionInfo;
	}

}
