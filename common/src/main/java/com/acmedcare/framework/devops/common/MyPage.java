package com.acmedcare.framework.devops.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class MyPage<T> implements Serializable {

  private static final long serialVersionUID = 513549788175534677L;

  /**
   * 第一页 页号
   */
  @JsonIgnore
  private final int first = 1;
  /**
   * 页面大小:一个页面显示多少个数据
   */
  private int size = 1;
  /**
   * 数据总数：一共有多少个数据
   */
  private int rowCount = 0;
  /**
   * 页面总数
   */
  private int pageCount = 1;
  /**
   * 当前页号, 采用自然数计数 1,2,3,...
   */
  private int num = 1;
  /**
   * 当前页面开始行, 第一行是0行
   */
  @JsonIgnore
  private int startRow = 0;
  /**
   * 最后页 页号,总页数
   */
  @JsonIgnore
  private int last = 1;

  /**
   * 下一页 页号
   */
  @JsonIgnore
  private int next = 1;
  /**
   * 前页 页号
   */
  @JsonIgnore
  private int prev = 1;

  /**
   * 页号式导航, 起始页号
   */
  @JsonIgnore
  private int start = 1;
  /**
   * 页号式导航, 结束页号
   */
  @JsonIgnore
  private int end = 1;
  /**
   * 页号式导航,最多显示页号数量为numCount+1;这里显示11页。
   */
  @JsonIgnore
  private int numCount = 10;

  /**
   * 总共多少页
   */
  @JsonIgnore
  private int count = 1;

  /**
   * 结果集
   */
  @SuppressWarnings("unchecked")
  private List<T> list;

  /**
   * @param size 一个页面显示多少个数据
   * @param pn 第几页
   * @param rowCount 总的记录数
   */
  public MyPage(int size, int pn, int rowCount) {

    size = size <= 0 ? 1 : size;
    pn = pn <= 0 ? 1 : pn;
    rowCount = rowCount < 0 ? 0 : rowCount;

    this.num = pn; // 当前第几页
    this.size = size; // 每页的大小
    this.rowCount = rowCount; // 总记录数

    this.pageCount = (int) Math.ceil((double) rowCount / size);
    pageCount = pageCount <= 0 ? 1 : pageCount;
    this.count = this.pageCount;

    this.num = Math.min(this.num, pageCount);
    this.num = Math.max(1, this.num);

    this.last = this.pageCount;
    this.next = Math.min(this.pageCount, this.num + 1);
    this.prev = Math.max(1, this.num - 1);

    this.startRow = (this.num - 1) * size;

    // 计算page 控制
    start = Math.max(this.num - numCount / 2, first);
    end = Math.min(start + numCount, last);
  }

  /**
   * 获取开始条数
   */
  @JsonIgnore
  public int getFirstResult() {
    return startRow;
  }

  /**
   * 获取截止条数
   */
  @JsonIgnore
  public int getLastResult() {
    return startRow - 1 + size;
  }

  @JsonIgnore
  public int getMaxResults() {
    return size;
  }
}

