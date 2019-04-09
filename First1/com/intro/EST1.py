'''
Created on Oct 25, 2016

@author: iDeliver
'''
from selenium import webdriver
chromedriverpath="C:\chromedriver_win32\chromedriver.exe"
driver = webdriver.Chrome(chromedriverpath)
driver.get("https://est1.nupocext.net/content/")
driver.find_element_by_xpath('//*[@id="RegionSelectorModal"]/div/div/div[2]/div/div[3]/div/div[1]/div/button').click()
driver.find_element_by_xpath('//*[@id="RegionSelectorModal"]/div/div/div[2]/div/div[3]/div/div[1]/div/div/ul/li[4]/a/span[1]').click()
driver.find_element_by_id("modal-footer-btn").click()
driver.implicitly_wait(5)
#//*[@id="Main_Login_txtUserName"]
print(driver.title)
driver.implicitly_wait(5)

#search_input = driver.find_element_by_name("ctl00$ctl00$Main$Login$txtUserName")
#search_input.clear()
#search_input.send_keys("dsqa319")
driver.find_element_by_name("ctl00$ctl00$Main$Login$txtUserName").send_keys("dsqa319")

#driver.find_element_by_name("ctl00$ctl00$Main$Login$txtUserName").send_keys("dsqa319")
driver.find_element_by_xpath("//*[@id='Main_Login_txtPassword']").send_keys("welcome123")
driver.find_element_by_xpath("//*[@id='Main_Login_btnLoginEnter']").click()
driver.implicitly_wait(6)
driver.find_element_by_id("btnOK").click()
driver.find_element_by_partial_link_text("/clp/customer/outage/outagelogin.aspx").click()
driver.implicitly_wait(5)
driver.find_element_by_id("ctl00_PageContent_rblPowerOutage_0").click()
driver.find_element_by_xpath("//*[@id='ctl00_PageContent_iBtnContinueOutageReporting']").click()
print(driver.title)

