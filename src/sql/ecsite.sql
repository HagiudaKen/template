drop database if exists ecsite;
create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;
create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists items;
create table items(
item_id int not null primary key auto_increment,
item_name varchar(30),
player int,
playtime int,
difficulty int,
price int,
stocks int,
img_path varchar(255),
simpleinfo varchar(50),
detailinfo varchar(255),
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

#-----ユーザー情報
insert into userinfo() values


#-----商品詳細（ID・商品名・プレイ人数・所要時間・難易度・値段・在庫数・画像パス・簡易情報文・詳細情報文）
insert into items(item_id,item_name,player,playtime,difficulty,price,stocks,img_path,simpleinfo,detailinfo) values
(1,"カタン",3,2,3,4100,50,"katan.png",
"名作中の名作！開拓！発展！そして交渉！？",
"未開の島を舞台に、資源を使って道や町などを作り、発展させていく世界的にも有名なゲームです。
1995年にドイツゲーム大賞を受賞しています。
３〜４人用ゲームで、追加ルールや拡張セットを加えれば２〜６人でプレイできます。
プレイヤーはサイコロの目によって産出される資源を集めながら、カタン島を開拓していきます。
勝利するためには様々な方法で一定のポイントを貯める必要がありますが、どの行動をするにも資源が必須となります。"),

(2,"ガイスター",2,1,1,1800,50,"gaistar.jpg",
"1ゲーム10分くらいで終わるという手軽さながら、何度やっても飽きないというオススメ名作ゲームです！",
"30年以上前に発売された名作「ガイスター」。
「赤の悪いオバケ」と、「青のいいオバケ」がいて、相手の「青いオバケ」をすべて取れば勝ちですが、
「赤のオバケ」をすべて取ってしまうと負けになってしまいます。
ポイントは相手からはオバケの区別が出来ないこと。"),

(3,"カルカソンヌ",2,3,2,3200,50,"carcassonne.jpg",
"タイルをつなげて点数ゲット着実にいく？それともビッグに？",
"道や城、修道院などの絵の描かれたタイルを並べて、なるべく長い道を作ったり、大きな城を作ったりするゲームです。
なるべく長い道や城が完成すれば高得点ですが、途中で邪魔をされたりしてしまうので、見極めが肝心です。
世界大会も開かれており、経験者同士だと真剣勝負となるゲームですが、ルールは非常に簡単で初心者でも楽しむことができます。
運と戦略のバランスも良く、初心者が経験者に勝つ場合もある名作ゲームです。"),

(4,"オセロ",2,2,1,1800,50,"game028.png",
"言わずと知れた有名ゲーム奥深さで人気です",
"知らない人はいないといっても過言ではないほど世界的にも有名な2人用ゲームです。
子供から大人までどんな人でも楽しめるとてもシンプルなルールでありながら、その奥深さでたくさんの人に愛されています。");

