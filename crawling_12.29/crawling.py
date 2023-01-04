import requests
import re
from fake_useragent import UserAgent
from bs4 import BeautifulSoup
import os

class funkeys:
    def __init__(self, num):
        self.num = num

        
    def crawling(self, url, kind):
        url = url
        headers = { 'User-Agent': UserAgent().chrome }
        res = requests.get(url, headers=headers)
        res.raise_for_status()
        soup = BeautifulSoup(res.content,'html.parser')
        items= soup.find_all("div", attrs={"class":"col-md-6"})

        allLIst = []
        for item in items:
            tmp = []
            if item.find("div", {"class":"pull-left title"}) is None:
                continue
            
            name = item.find("div", {"class":"pull-left title"}).text  #제품명
            name = name.replace('\n','')

            subTitle=""
            if item.find("div", {"class":"sub_title"}) is not None:
                subTitle = item.find("div", {"class":"sub_title"}).text
            else:
                subTitle=""
            
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
            state=0
            
            if "품절" in status:
                continue
            elif "판매중" in status:
                state = "판매중"

            madeIn=""
            if "VARMILO" in name or "CMYKO" in name:
                brand = "varmilo"
                madeIn = "중국"
            if "ZOMO" in name:
                brand = "zomo"
            elif "DUCKY" in name:
                brand = "ducky"
                madeIn = "대만"
            elif "VARMILO" in name:
                brand = "varmilo"
            elif "Zoom" in name:
                brand = "zoom"
                madeIn = "중국"
            elif "Wuque" in name or "Clickitty" in name or "WS" in name:
                brand = "wuque studio"
                madeIn = "중국"
            elif "BRAVOTEC" in name or "EQUALE" in name:
                brand = "브라보텍"
                madeIn = "중국"
            elif "펀키스" in name:
                 brand = "펀키스"
                 madeIn = "중국"
            elif "SandunArt" in name:
                 brand = "sandunArt"
                 madeIn = "대한민국"
            else:
                brand =""

            if kind=="키보드":
                kategorie=""  
                if "PRO" in name or "MINI" in name or "SF" in name:
                    kategorie = "60"
                elif "87" in name or "TKL" in name:
                    kategorie = "80"
                elif "108" in name:
                    kategorie = "100"
                elif "DUCKY" in name:
                    kategorie = "100"
                else:
                    kategorie =""
                    
            elif kind=="악세서리": 
                if "이중 사출" in name or "이중사출" in name or "Keycap" in name or "이색사출" in name:
                    kategorie = "키캡"
                    madeIn = "중국"
                elif "고양이 발바닥" in name or "게이밍" in name or "아티산" in name or "축구공" in name or "기능키" in name:
                    kategorie = "포인트 키캡"
                elif "데스크 패드" in name or "DESK PAD" in name or "장패드 " in name or "축구공" in name or "기능키" in name:
                    kategorie = "장패드"
                elif "EQUALE" in name:
                    kategorie = "주변기기"
                elif "케이블" in name:
                    kategorie = "케이블"
                elif "Opener" in name or "Films" in name or "Puller" in name or "Springs" in name:
                    kategorie = "도구"
                elif "Switch" in name or "MMswitch" in name:
                    kategorie = "스위치"
                else:
                    kategorie ="도구"

            price = (item.find("div", {"class":"pull-right price gray"}).text).replace('￦','').replace(',','').strip()

    
            optionList = []
            options = item.find_all("div", {"class":"col-md-6 switchop"})
            for option in options:
                optionList.append((option.find("span", {"class":"optTitle"}).text).strip())
                optionList.append(((option.find("div", {"class":"pull-right"}).text).replace('￦','')).replace(',','').strip())

            tmp.append(brand)
            tmp.append(kind)
            tmp.append(name)
            tmp.append(subTitle)
            tmp.append(kategorie)
            tmp.append(state)
            tmp.append(madeIn)
            try:
                tmp.append(optionList[0])
                tmp.append(int(optionList[1]))
                tmp.append(optionList[0] if None == 0 else 10)
            except IndexError:
                tmp.append("")
                tmp.append(int(price))
                tmp.append(10)
                
            try:
                tmp.append(optionList[2])
                tmp.append(int(optionList[3]))
                tmp.append(optionList[2] if None == 0 else 10)
            except IndexError:
                tmp.append("")
                tmp.append(0)
                tmp.append(0)
                
            try:
                tmp.append(optionList[4])
                tmp.append(int(optionList[5]))
                tmp.append(optionList[4] if None == 0 else 10)
            except IndexError:
            
                tmp.append("")
                tmp.append(0)
                tmp.append(0)
                
            try:
                tmp.append(optionList[6])
                tmp.append(int(optionList[7]))
                tmp.append(optionList[6] if None == 0 else 10)
            except IndexError:
                tmp.append("")
                tmp.append(0)
                tmp.append(0)
                
            try:
                tmp.append(optionList[8])
                tmp.append(int(optionList[9]))
                tmp.append(optionList[8] if None == 0 else 10)
            except IndexError:
                tmp.append("")
                tmp.append(0)
                tmp.append(0)
                
            try:
                tmp.append(optionList[10])
                tmp.append(int(optionList[11]))
                tmp.append(optionList[10] if None == 0 else 10)
            except IndexError:
                tmp.append("")
                tmp.append(0)
                tmp.append(0)

            self.num+=1
            if "ca_id=10" in url:
                link2 = "VARMILO_img"
            elif "ca_id=70" in url:
                link2 = "DUCKY_img"
            elif "ca_id=a0" in url:
                link2 = "ZOOM_img"
            elif "ca_id=20" in url:
                link2 = "accessory_img"

            tmp.append('img/'+ link2 +'/'+str(self.num)+'.jpg')
            
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_1.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_1.jpg')
            else:
                tmp.append('')
                
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_2.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_2.jpg')
            else:
                tmp.append('')
                
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_3.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_3.jpg')
            else:
                tmp.append('')
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_4.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_4.jpg')
            else:
                tmp.append('')
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_5.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_5.jpg')
            else:
                tmp.append('')
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_6.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_6.jpg')
            else:
                tmp.append('')
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_7.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_7.jpg')
            else:
                tmp.append('')
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_8.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_8.jpg')
            else:
                tmp.append('')
            if os.path.exists('C:/crawling_img/'+ link2 +'/'+str(self.num)+'_9.jpg'):
                tmp.append('img/'+ link2 +'/'+str(self.num)+'_9.jpg')
            else:
                tmp.append('')

            allLIst.append(tmp)
            
        return allLIst
    
    def renum(self):
        return self.num

#[인덱스] 제조사, 종류, 제품명, 서브타이틀, 카테고리, 판매 상태, 원산지, 옵션1, 가격, 재고(단일 상품 재고), 옵션2, 가격, 재고, 옵션3, 가격, 재고. 옵션4, 가격, 재고, 옵션5, 가격,재고, 옵션6, 가격, 재고, 메인 이미지, 상세 이미지1, 상세 이미지2, 상세 이미지3

#회원가입:
#로그인:
##num = 0
##c1 = funkeys(num)
##print(c1.crawling("https://funkeys.co.kr/shop/list.php?ca_id=10", "키보드")) #VARMILO
##num = c1.renum()
##
##c2 = funkeys(num)
##print(c2.crawling("https://funkeys.co.kr/shop/list.php?ca_id=70", "키보드")) #DUCKY
##num = c2.renum()
##
##c3 = funkeys(num)
##print(c3.crawling("https://funkeys.co.kr/shop/list.php?ca_id=a0", "키보드")) #ZOOM
##num = c3.renum()
##
##c4 = funkeys(num)
##print(c4.crawling("https://funkeys.co.kr/shop/list.php?ca_id=20", "악세서리")) #ACCESSORIES
##print(c4.renum())

