package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;

import com.google.common.collect.ImmutableMap;

public class NetworkLogs{
	
	public static void getNetworkLogs(WebDriver driver) {
		
	//get the network logs
	DevTools devTools = ((ChromeDriver) driver).getDevTools();
	devTools.createSession();
	devTools.send(new Command<>("Network.enable",ImmutableMap.of()));
	devTools.addListener(Network.responseReceived(), l ->{
		System.out.println("Response url: ");
		System.out.println(l.getResponse().getUrl());
	});
	devTools.addListener(Network.responseReceived(), l ->{
		System.out.println("Response url: ");
		System.out.println(l.getResponse().getStatus());
	});
	devTools.addListener(Network.requestWillBeSent(), l ->{
		System.out.println("Request url: ");
		System.out.println(l.getRequest().getUrl());
	});
	devTools.addListener(Network.requestWillBeSent(), l ->{
		System.out.println("Request method: ");
		System.out.println(l.getRequest().getMethod());
	});
	}
	
	
}
