----------------------------------分析四种GC的方式-------------------------------------------

<table class="MsoTableGrid" border="1" cellspacing="0" cellpadding="0" style="border-collapse:collapse;border:none">
 <tbody><tr style="height:44.5pt">
  <td width="78" valign="top" style="width:58.25pt;border:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:44.5pt">
  <p class="MsoNormal">&nbsp;</p>
  </td>
  <td width="66" valign="top" style="width:49.5pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt;height:44.5pt">
  <p class="MsoNormal">128M</p>
  </td>
  <td width="138" valign="top" style="width:103.5pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt;height:44.5pt">
  <p class="MsoNormal">512M</p>
  </td>
  <td width="132" valign="top" style="width:99.0pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt;height:44.5pt">
  <p class="MsoNormal">1G</p>
  </td>
  <td width="139" valign="top" style="width:104.55pt;border:solid windowtext 1.0pt;
  border-left:none;padding:0in 5.4pt 0in 5.4pt;height:44.5pt">
  <p class="MsoNormal">4G</p>
  </td>
 </tr>
 <tr style="height:51.25pt">
  <td width="78" valign="top" style="width:58.25pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt;height:51.25pt">
  <p class="MsoNormal">SerialGC</p>
  </td>
  <td width="66" valign="top" style="width:49.5pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:51.25pt">
  <p class="MsoNormal">OOM</p>
  </td>
  <td width="138" valign="top" style="width:103.5pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:51.25pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了多次</span>youngGC<span lang="ZH-CN">和有几次后发生了</span>Metaspace<span lang="ZH-CN">的清理，创建对象数：</span>6855</p>
  </td>
  <td width="132" valign="top" style="width:99.0pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:51.25pt">
  <p class="MsoNormal"><span lang="ZH-CN">只发生了多次</span>youngGC<span lang="ZH-CN">，创建对象数：</span>8095</p>
  </td>
  <td width="139" valign="top" style="width:104.55pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:51.25pt">
  <p class="MsoNormal"><span lang="ZH-CN" style="background:yellow">只发生了</span><span style="background:yellow">1<span lang="ZH-CN">次</span></span>youngGC<span lang="ZH-CN" style="background:yellow">，创建对象数：</span><span style="background:
  yellow">4176</span></p>
  </td>
 </tr>
 <tr style="height:58.0pt">
  <td width="78" valign="top" style="width:58.25pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt;height:58.0pt">
  <p class="MsoNormal">ParallelGC</p>
  </td>
  <td width="66" valign="top" style="width:49.5pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:58.0pt">
  <p class="MsoNormal">OOM</p>
  </td>
  <td width="138" valign="top" style="width:103.5pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:58.0pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了多次</span>youngG<span lang="ZH-CN">和几次</span>fullGC</p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>6817</p>
  </td>
  <td width="132" valign="top" style="width:99.0pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:58.0pt">
  <p class="MsoNormal"><span lang="ZH-CN">发了多</span>youngGC<span lang="ZH-CN">的次数比之前少，并且</span>fullGC<span lang="ZH-CN">只有一次</span></p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>8610</p>
  </td>
  <td width="139" valign="top" style="width:104.55pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:58.0pt">
  <p class="MsoNormal"><span lang="ZH-CN" style="background:yellow">只发生了</span><span style="background:yellow">1<span lang="ZH-CN">次</span></span>youngGC<span lang="ZH-CN" style="background:yellow">，创建对象数：</span><span style="background:
  yellow">6470</span></p>
  </td>
 </tr>
 <tr style="height:49.0pt">
  <td width="78" valign="top" style="width:58.25pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt;height:49.0pt">
  <p class="MsoNormal">CMSGC</p>
  </td>
  <td width="66" valign="top" style="width:49.5pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:49.0pt">
  <p class="MsoNormal">OOM</p>
  <p class="MsoNormal"><span lang="ZH-CN">发生了多次的</span>yangGC<span lang="ZH-CN">和</span>fullGC</p>
  </td>
  <td width="138" valign="top" style="width:103.5pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:49.0pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了很多很多次</span>GC<span lang="ZH-CN">没有</span>fullGC</p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>8484</p>
  </td>
  <td width="132" valign="top" style="width:99.0pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:49.0pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了很多很多次</span>GC<span lang="ZH-CN">没有</span>fullGC</p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>8939</p>
  </td>
  <td width="139" valign="top" style="width:104.55pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:49.0pt">
  <p class="MsoNormal"><span lang="ZH-CN" style="background:yellow">只发生了</span>youngGC<span lang="ZH-CN" style="background:yellow">，没有用到</span><span style="background:
  yellow">CMSgc</span></p>
  <p class="MsoNormal"><span lang="ZH-CN" style="background:yellow">创建对象数：</span><span style="background:yellow">7957</span></p>
  </td>
 </tr>
 <tr style="height:70.15pt">
  <td width="78" valign="top" style="width:58.25pt;border:solid windowtext 1.0pt;
  border-top:none;padding:0in 5.4pt 0in 5.4pt;height:70.15pt">
  <p class="MsoNormal">G1GC</p>
  </td>
  <td width="66" valign="top" style="width:49.5pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:70.15pt">
  <p class="MsoNormal">OOM</p>
  </td>
  <td width="138" valign="top" style="width:103.5pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:70.15pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了很多很多次</span>GC<span lang="ZH-CN">，没有</span>fullGC</p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>7898</p>
  </td>
  <td width="132" valign="top" style="width:99.0pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:70.15pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了很多很多次</span>GC<span lang="ZH-CN">，没有</span>fullGC</p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>9045</p>
  </td>
  <td width="139" valign="top" style="width:104.55pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  padding:0in 5.4pt 0in 5.4pt;height:70.15pt">
  <p class="MsoNormal"><span lang="ZH-CN">发生了几次</span>GC<span lang="ZH-CN">，没有</span>fullGC</p>
  <p class="MsoNormal"><span lang="ZH-CN">创建对象数：</span>9654</p>
  </td>
 </tr>
</tbody></table>

------------------------------------------------总结-------------------------------------------------------------------
串行GC：在128m-1m 中GC的数量增加创建对象数变多，但加到4g时，只发生了一次young区GC，
因为堆够大，但是创建对象数反而更少，怀疑我操作是否存在存在问题。

并行GC：在Xmx 变大的过程中GC次数变少，创建对象数也变多，但是加到4G时依然有对象数变少的
的问题，怀疑我电脑本身有啥问题，本机的内存时8G。

CMSG：从128-4g的 增加时创建对象数在稳步提升，加到4g也没有出现只GC一次，并且对象数减少的情况。

综合分析在内存足够大时选用G1GC可以有更大的吞吐量，在要求响应要快时，CMSGC是更好的选择。
并行gc稳定，串行gc不表。
问题：在前三种GC，Xmx=4g 的时候都出现对象数比1g少，这是否存在问题？