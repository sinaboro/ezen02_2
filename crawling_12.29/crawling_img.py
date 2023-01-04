import os
import requests
import re
from fake_useragent import UserAgent
from bs4 import BeautifulSoup
from urllib.request import urlopen
from urllib.parse import quote_plus

class funkeys_img:
    def __init__(self):
        self.url=""
        self.link=""
        self.num=1
        
    def set_main_url(self, url):
        self.url = url
        
        if "ca_id=10" in url:
            self.link = "VARMILO_img"
        elif "ca_id=70" in url:
            self.link = "DUCKY_img"
        elif "ca_id=a0" in url:
            self.link = "ZOOM_img"
        elif "ca_id=20" in url:
            self.link = "accessory_img"
            
        try:
            os.mkdir("C:/crawling_img")
        except FileExistsError:
            None
            
        try:
            os.mkdir("C:/crawling_img/"+self.link)
        except FileExistsError:
            None
        
    def get_url(self):
        #os.mkdir("C:/crawling_img")
        url = self.url
        headers = { 'User-Agent': UserAgent().chrome }
        res = requests.get(url, headers=headers)
        res.raise_for_status()
        soup = BeautifulSoup(res.content,'html.parser')
        items= soup.find_all("div", attrs={"class":"item-content"})

        linkList = []
        for item in items:
            name = item.find("a").text
            if name.find("리퍼") != -1:
                continue
            elif name.find("예약판매") != -1:
                continue
            elif name.find("Feather") != -1:
                continue
            elif name.find("Dreams") != -1:
                continue
            elif name.find("Springs") != -1:
                continue
            
            status = item.find("div", {"class":"dcView"}).text #판매 상태
            if "품절" in status:
                continue
    
            linkStr = item.find("a")["href"]
            linkIndex = linkStr.find("it_id=")
            link = linkStr[(linkIndex+6):(linkIndex+16)]
            linkList.append(link)

        return linkList
    
    def img_crawling(self):
        url_list = self.get_url()
        
        imgList=[]
        for url_id in url_list:
            n=1
            tmp=[]
            url = "https://funkeys.co.kr/shop/item.php?it_id="+url_id
            headers = { 'User-Agent': UserAgent().chrome }
            res = requests.get(url, headers=headers)
            res.raise_for_status()
            soup = BeautifulSoup(res.content,'html.parser')

            items= soup.find_all("div", attrs={"class":"at-content"})
            #print(url_id)
            for item in items:
                linkStr1 = item.find_all("div", attrs={"class":"item-image"})
                link1 = linkStr1[0].find("img")["src"]
                tmp.append(link1)
                with urlopen(link1) as f:
                    with open('C:/crawling_img/'+ self.link +'/'+str(self.num)+'.jpg','wb') as h:
                        img = f.read()
                        h.write(img)
                
                linkStr2 = item.find("div", attrs={"class":"item-explan"})
                links2 = linkStr2.find_all("img")
                for link2 in links2:
                    link2 = link2["src"]
                    if url_id == "1505288225" and "1709" in link2:
                        link2 = "https://funkeys.co.kr"+link2
                    if url_id == "1505208831" and "1709" in link2:
                        link2 = "https://funkeys.co.kr"+link2
                    with urlopen(link2) as f:
                        with open('C:/crawling_img/'+ self.link +'/'+str(self.num)+'_'+ str(n)+'.jpg','wb') as h:
                            img = f.read()
                            h.write(img)
                            n+=1
                    tmp.append(link2)
                self.num+=1
            imgList.append(tmp)
            
        return imgList
                 
img = funkeys_img()

img.set_main_url("https://funkeys.co.kr/shop/list.php?ca_id=10")
img.get_url()
img.img_crawling()
print("VARMILO 완료")
img.set_main_url("https://funkeys.co.kr/shop/list.php?ca_id=70")
img.get_url()
img.img_crawling()
print("DUCKY 완료")
img.set_main_url("https://funkeys.co.kr/shop/list.php?ca_id=a0")
img.get_url()
img.img_crawling()
print("ZOOM 완료")
img.set_main_url("https://funkeys.co.kr/shop/list.php?ca_id=20")
img.get_url()
img.img_crawling()
print("accessory 완료")
print("이미지 크롤링 완료")



