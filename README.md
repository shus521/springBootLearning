## 小工具接口
### 大小写转换
#### 接口地址
   url：``http://IP:8080/common/stringToLower``
#### 请求方式:GET
#### 请求参数
    |名称 |必选  |类型  |说明 |
    |:----|:----:|:----:|:----|
    |type |false |int   |1转小写2转大写；默认1|
    |input|true  |String|需要转换的字符串|
#### 返回参数
    {
          "code": 1,
          "msg": "转换结果"
    }
### 数字转人民币
#### 接口地址
   url：``http://IP:8080/common/getMoney``
#### 请求方式:GET
#### 请求参数
    |名称 |必选  |类型  |说明 |
    |:----|:----:|:----:|:----|
    |money|true  |int   |1转小写2转大写；默认1|
#### 返回参数
    {
          "code": 1,
          "msg": "转换结果"
    }