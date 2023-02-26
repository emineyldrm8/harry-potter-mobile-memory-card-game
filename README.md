# harry-potter-mobile-memory-card-game
harry potter mobile memory card game
# ÖZET
Bu projede Android ve bulut teknolojileri kullanılarak bir   hafıza   oyunu   tasarlanacaktır.Oyuncu   tarafından   sec¸ilen iki   kart   es¸les¸tig˘inde   oyuncu   belirlenen   o¨zelliklere   go¨re puan   kazanır.Eg˘er   oyuncu   yanlıs¸   ve   es¸les¸meyen   iki   kart sec¸erse   bu   kartlar   eski   hallerine   geri   do¨ner   ve   oyuna devam edilir.Proje sonucunda beklenen oyuncu ve kart bilgilerinin   bulutta   tutulması,giris¸   yapmak   ic¸in   bir   giris¸ ekranı,oyunun oyuncu sayısının ve zorluk seviyesinin sec¸ileceg˘i   bir   ekran   ve   seviyelere   go¨re   olus¸turulmus¸   kart oyunu olus¸turulmasıdır.Toplamda 44 adet kart vardır.Bu kartlar seviyelerine,gruplarına go¨re ayrılmalıdır
# GİRİŞ
Projede kullanılacak kartlar
”Gryffindor,Slytherin,Ravenclaw,Hufflepuff” olmak uzere ¨
4 eve ayrılmıs¸tır.Her kartın bir ismi ve puanı vardır.Bu
bilgiler oyuncu dogru kartları es¸lets¸tirdi ˘ ginde yapılacak puan ˘
hesabı ic¸in kullanılacaktır.Toplamda 44 adet kart bulutta
tutulmalıdır.Kartlarda kullanılacak resimler base64 formatına
c¸evrilecektir.Bulut platformu olarak Google,Amazon gibi
platformlar kullanılabilir.
Oyun giris¸ ekranı kullanıcı adı ve s¸ifre ile giris¸ yapmayı
gerektirir.Oyun ekranında ise ”Tekli Oyuncu” ”C¸ oklu
Oyuncu” olmak uzere sec¸im yapılabilir.Aynı s¸ekilde 2x2,4x4 ¨
veya 6x6 olmak uzere oyun zorluk seviyesi de sec¸ilebilir. ¨
Oyun ic¸inde kartlar ilk bas¸ta rastgele dagıtılır.Oyuncu ˘
es¸les¸en kartları bulmak ic¸in tekli oyuncu da 45 c¸oklu oyuncu
da 60 saniye sureye sahiptir.Bu s ¨ ure boyuncu belirlenen ¨
s¸arkı arka fonda c¸alacak,dogru es¸les¸mede kullanıcıyı tebrik ˘
eden ve yanlıs¸ es¸les¸mede kullanıcıyı uyaran ayrı bir muzik ¨
c¸alacaktır.Oyun skoru ise sec¸ilen kartların ozelliklerine,bitis¸ ¨
suresine g ¨ ore hesaplanır. 

# YÖNTEM

˙Ilk     olarak     projeye     firebase     u¨zerindeki     is¸lemleri yaparak bas¸ladık.44 adet kartı ve bu kartların isim- lerini,o¨zelliklerini,puanlarını  firebase’de  tutuyoruz.Firebase’e eklerken resimleri ilk bas¸ta base64 formatına c¸eviriyoruz.Daha sonra    ise    tekrardan    bunları    resime    c¸evirerek    bulutta tutuyoruz.Oyun     esnasında     resimler     firebase     u¨zerinden c¸ekiliyor.Aynı   s¸ekilde   kullanıcı   adlarını   ve   s¸ifreleri   de bulut  u¨zerinde  tutuyoruz.Kullanıcının  bu  o¨zellikleri  bulutta olus¸turulmus¸ bir veritabanında tutuluyor.Oyunda kullanılacak bilgilerin  hepsi  firebase  u¨zerinde  tutuluyor  ve  oyun  bas¸ladıg˘ı zaman bu bilgilerin hepsi firebase’den geliyor.
Daha sonra oyunun giris¸ ekranını yaptık.Giris¸ ekranında
kullanıcı adı ve s¸ifre dogru girildi ˘ ginde kullanıcı ˘
oyun ozelliklerini sec¸ece ¨ gi ekrana y ˘ onlendiriliyor.E ¨ ger ˘
kullanıcının hesabı yoksa hesap olus¸turması ic¸in bir kayıt
ol ekranı geliyor.Eger kullanıcı isterse s¸ifresinde de ˘ gis¸iklik ˘
yapabiliyor.Yapılan bu degis¸iklikler ise aynı s¸ekilde firebase’e ˘
yansıyor.Kayıt olduktan sonra aynı s¸ekilde kullanıcı oyun
ozelliklerini sec¸ece ¨ gi ekrana y ˘ onlendiriliyor.Bu ekranda ¨
kullanıcı oyunu tekli oyuncu olarak mı yoksa c¸oklu
oyuncu olarak mı oynamak istedigini sec¸ecek.Aynı zamanda ˘
kullanıcının sec¸ebilecegi 3 adet oyun seviyesi vardır.Bunlar ˘
2x2,4x4 ve 6x6’dır.Bu seviyelerden istedigini sec¸en oyuncu ˘
artık oyuna gec¸ebilir.
Tekli oyunculu oyunda sure 45 saniyedir.Oyun s ¨ uresince ¨
arka planda oyun muzi ¨ gi c¸alar.Ekranda koydu ˘ gumuz butonlar ˘
sayesinde kullanıcı istedigi zaman bu m ˘ uzi ¨ gi kapatabilir.Bu ˘
sure zarfında oyuncu kartların es¸ini bulmalıdır.Kullanıcı do ¨ gru ˘
kartları buldugunda ˘ ornek olarak s¸u s¸ekilde bir puanlama ¨
yapılır:
Harry Potter(Puan :10 , Ev: Gryffindor)
Oyuncu dogru bir es¸les¸tirme yaparsa [(2*kartın puanı * evin ˘
katsayısı) * (kalan sure / 10) ] kadar puan kazanır. ¨
Eger kullanıcı yanlıs¸ bir es¸les¸me yaparsa s¸u s¸ekilde bir ˘
puanlama yapılır:
Harry Potter(Puan :10 , Ev: Gryffindor)
Oyuncu  dog˘ru  bir  es¸les¸tirme  yaparsa  [(2*kartın  puanı  *  evin katsayısı) * (kalan su¨re / 10) ] kadar puan kazanır.

Eg˘er   kullanıcı   yanlıs¸   bir   es¸les¸me   yaparsa   s¸u   s¸ekilde   bir puanlama yapılır:

Yanlıs¸ bir es¸les¸tirme durumunda iki kart aynı evden ise [(kartların toplam puanı / evin katsayısı) * (gec¸en su¨re / 10)] kadar puan kaybeder.
Yanlıs¸ bir es¸les¸tirme durumunda iki kart farklı evden ise [(kartların puan ortalaması * Ev 1 katsayı * Ev 2 katsayı )
* (gec¸en su¨re / 10)] kadar puan kaybeder.

C¸ oklu  oyuncuda  ise  kartlar  oyunun  bas¸ında  rastgele  arka yu¨zleri   kapalı   olacak   s¸ekilde   dag˘ıtılır.Bu   kartlar   firebase u¨zerinden  gelir.1.  Oyuncu  oyuna  bas¸lar  ve  bir  kartı  sec¸er. Daha  sonrasında  kartın  es¸ini  bulmaya  c¸alıs¸ır.  Eg˘er  kartın es¸ini bulursa aynı oyuncu oyuna devam eder.Oyuncu kartın es¸ini  bulamayana  kadar  oynamaya  devam  eder.Eg˘er  kartın es¸ini  bulamazsa  sıra  rakip  oyuncuya  gec¸er.Rakip  oyuncu  da aynı s¸ekilde oyuna bas¸lar ve bir kartı sec¸er. Daha sonrasında kartın  es¸ini  bulmaya  c¸alıs¸ır.  Eg˘er  kartın  es¸ini  bulursa  aynı oyuncu oyuna devam eder.Oyuncu kartın es¸ini bulamayana kadar   oynamaya   devam   eder.Eg˘er   kartın   es¸ini   bulamazsa sıra   rakip   oyuncuya   gec¸er.C¸ oklu   oyuncunun   oyun   su¨resi
60  saniyedir.Aynı  s¸ekilde  bu  su¨re  zarfında  da  arka  fonda mu¨zik   c¸almaya   devam   eder.Dog˘ru   kartlar   bulundug˘unda tebrik  mu¨zig˘i,  yanlıs¸  kartlar  es¸les¸tig˘inde  ise  uyarı  mu¨zig˘i verilir.C¸ oklu oyuncuda kart puanı hesaplaması tekli oyuncuda oldug˘u gibidir.

Oyun boyunca kullanılacak kartlar hakkında bilgiler as¸ag˘ıda verilmis¸tir:

Ev katsayıları Gryffindor : 2
Slytherin : 2
Hufflepuff : 1
Ravenclaw : 1

Aynı s¸ekilde oyun boyunca kullanılan mu¨zikler de as¸ag˘ıda verilmis¸tir:

Oyun	su¨resince	c¸alacak	mu¨zik: https://www.youtube.com/watch?v=UuPb1J RCJMlist

Kartın es¸i bulundug˘unda: https://www.youtube.com/watch?v=BkBFl151KQI

Oyun	su¨resi	bittig˘i	zaman	: https://www.youtube.com/watch?v=ttdHX4cyoqQ

Su¨re	bitmeden	bu¨tu¨n	kartların	es¸i	bulununca: https://www.youtube.com/watch?v=jgtRU KBkNM

En  sonda  kazanan  oyuncu  ekranda  go¨sterilir  ve  arkada  bir alkıs¸  sesi  duyulur.Bo¨ylece  oyun  bitmis¸  olur.  Projenin  is¸leyis¸ s¸ekli bu s¸ekildedir.
<br></br>
![image](https://user-images.githubusercontent.com/73225797/221412254-7c3e5342-0164-43a7-8394-deee99959be6.png)
![image](https://user-images.githubusercontent.com/73225797/221412265-59bbd0cf-842d-4969-8ff0-fa2ffe846efe.png)
![image](https://user-images.githubusercontent.com/73225797/221412280-dc1e8f8a-5f20-45db-97ca-4e02011e56f2.png)
![image](https://user-images.githubusercontent.com/73225797/221412294-e5d2c4ce-2cf7-4478-8329-47e1d72ba71c.png)
<br></br>

# AKIŞ DİYAGRAMI
<br></br>
![image](https://user-images.githubusercontent.com/73225797/221412333-0c21c073-0e6c-4f1d-8904-e87744bb6385.png)





