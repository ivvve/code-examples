package kcb.client

class KCBClient {
    fun directInquiry(rrn: String): String {
        val request = buildRequest(rrn)
        val fullText = send(request)
        checkResponse(fullText)
        return fullText
    }

    private fun buildRequest(rrn: String): String {
        return rrn + "Hello World!"
    }

    private fun send(request: String): String {
        return "response from kcb"
    }

    private fun checkResponse(fullText: String) {
        // error 응답 확인
    }
}
