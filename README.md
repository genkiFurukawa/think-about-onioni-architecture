# アーキテクチャ検討 / パッケージ検討
## このリポジトリでやりたいこと
これまで自分がやってきたパッケージ構成とオニオンアーキテクチャを採用するにあたって問題となる点を整理する

## 採用するアーキテクチャ
[オニオンアーキテクチャ](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)を採用する。

## サンプル
### パッケージの概要
- osu.shi.sample.v1: これまでやってきたパッケージ構成
- osu.shi.sample.v2: オニオンアーキテクチャを採用したパッケージ構成

### サンプルの概要
- 下記のAPIを提供する
    1. タスクの一覧を取得する
    1. タスクを登録する
    1. タスクを削除する

#### タスクの仕様
1. タスクはID、名前をもつ
1. タスクは同じIDで登録できない
1. タスク名は「タスク」で登録できない
1. タスクが1件しかないときは削除できない

## 既存構成の問題点
1. 責務があいまい
    - APIの外部仕様が変わった時に`@Service`のアノテーションがつくメソッドまで書き換えないといけない
        - APIの返り値の型が`ApiResponseList`から`ApiResponseObject`に変わっただけなのに、なぜ`@Service`のアノテーションがついたクラスまで書き換えないといけないのか？（SOLIDの何かの原則に違反しているような？
1. `@Service`のアノテーションが着くクラスに全ての処理が書かれており、変更がしにくい
    - Fat Service になっている <=> （いわゆる）ドメイン貧血症
    - 一覧取得と追加と削除は別機能では？（SOLIDの何かの原則に違反しているような？）
    - 他の場所からもタスク関連の処理を使う時にタスクの仕様を`@Service`のアノテーションがついたクラスに書くと、仕様を見落とす可能性がある。また、他の`@Service`のアノテーションがついたクラスに同じメソッドを書くと、片方の更新のし忘れが発生する。