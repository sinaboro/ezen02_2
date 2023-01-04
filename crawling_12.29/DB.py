from crawling import *

import cx_Oracle as cx
conn = cx.connect("SCOTT","1234","127.0.01:1521/XE") #DB연동
cur = conn.cursor()
num = 0

sql = ("INSERT INTO productT (num, brand, kind, product, subTitle, categorie, state, madeIn,"+
            "option1, option1_price, option1_stock, option2, option2_price, option2_stock,"+
            "option3, option3_price, option3_stock, option4, option4_price, option4_stock,"+
            "option5, option5_price, option5_stock, option6, option6_price, option6_stock,"+
            "main_img, detailed_img1, detailed_img2, detailed_img3, detailed_img4, detailed_img5,"+
            "detailed_img6, detailed_img7, detailed_img8, detailed_img9) VALUES (seq_productT.nextval,"+
            ":1,:2,:3,:4,:5,:6,:7,:8,:9,:10,:11,:12,:13,:14,:15,:16,:17,:18,:19,:20,:21,:22,:23,:24,:25,:26,:27,:28,:29,:30,:31,:32,:33,:34,:35)")

def dbInsert(url, kind, num):
    db = funkeys(num)
    items = db.crawling(url, kind)
    for itme in items:
        cur.execute(sql,itme)
    return db.renum()


num = dbInsert("https://funkeys.co.kr/shop/list.php?ca_id=10", "키보드", num) #VARMILO
print("VARMILO 완료")
num = dbInsert("https://funkeys.co.kr/shop/list.php?ca_id=70", "키보드", num) #DUCKY
print("DUCKY 완료")
num = dbInsert("https://funkeys.co.kr/shop/list.php?ca_id=a0", "키보드", num) #ZOOM
print("ZOOM 완료")
num = dbInsert("https://funkeys.co.kr/shop/list.php?ca_id=20", "악세서리", num) #ACCESSORIES
print("accessory 완료")
print("DB업로드 완료")

cur.close()
conn.commit()
conn.close()

