<template>
  <div class="search">
    <input
        ref={refInput}
        placeholder="搜索音乐"
        type="text"
      />
    <SearchTip searchKey={searchKey} canShow={canShowTip} setCanShow={setCanShowTip} refInput={refInput} />
  </div>
</template>
<script>
</script>
<style>
.search {
  position: relative;
  display: flex;
  align-items: center;
  width: 280px;
  height: 34px;
  padding: 0 10px;
  margin-right: 28px;
  background: #f5f5f5;
  border-radius: 2px;

  svg {
    width: 15px;
    height: 15px;
    margin-right: 5px;
    color: #999;
    cursor: pointer;
  }

  input {
    width: 100%;
    font-size: 14px;
    line-height: 34px;
    background: #f5f5f5;
    border: none;

    &:focus {
      outline: none;
    }

    &::placeholder {
      color: #999;
    }
  }
}

</style>