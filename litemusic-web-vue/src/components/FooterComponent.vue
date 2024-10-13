<template>
    <footer class="footer">
        <div className="container">
            <p>
                开发者：
                <a class="link" href="https://github.com/cinderhk/LiteMusic">
                    cinderhk
                </a>
            </p>
            <p>
                本项目已开源在 Github 上，采用
                <a class="link" href="https://opensource.org/licenses/MIT">
                    MIT
                </a>
                开源协议
            </p>
            <p>
                本项目仅用于学习和研究目的，不得用于商业用途，任何个人或组织不得将其用于违法用途，否则后果自负
            </p>
        </div>
    </footer>
</template>

<script setup lang="ts">

</script>

<style lang="scss" scoped>
.footer {
margin-top: 20px;
width: 100%;
padding: 5px 0;
font-size: 14px;
font-weight: 100;
color: grey;
text-align: center;
background: #1f1f1f;

    p {
        margin: 14px 0;

        .link {
            color: grey;
            text-decoration: none;

            &:hover {
                color: #ffe443;
            }
        }
    }
}
</style>