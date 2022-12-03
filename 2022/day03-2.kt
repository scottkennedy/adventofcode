fun main() {
    var prioritySum = 0

    val groups = mutableListOf<MutableList<String>>()
    input.lines().forEach {
        if (groups.isEmpty() || groups.last().size == 3) {
            groups += mutableListOf(it)
        } else {
            groups.last() += it
        }
    }
    groups.forEach {
        val first = it[0].toCharArray().toSet()
        val second = it[1].toCharArray().toSet()
        val third = it[2].toCharArray().toSet()

        val overlap = first.intersect(second).intersect(third)

        overlap.forEach { item ->
            prioritySum += if (item.isLowerCase()) {
                item - 'a' + 1
            } else {
                item - 'A' + 26 + 1
            }
        }
    }

    println(prioritySum)
}

val inputTest = """
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw
""".trimIndent()
val input = """
    LdHVLDLDdHdtLMhcqCqGWcWg
    ZZQZSZnnJrQrJQJbfzfnWGWPWMcChMMPcqMnhFcF
    ZrzpWzfbpQpWbzvZWZpdtVtDNmRHNVptNDHt
    gzCjffWZCtCfZZVdqVSqJdvJndSt
    hMHLcmGLMLhHmsRMsSvsQSqrsrlJTTdV
    NPNGRGHGHNLczNzzZFWSFFCC
    VSBpcvNNbNWWSfGRwtJnRtrzzGzGGn
    jZlhTlQLHFLLZbwrzQQsttDtbs
    hmmPFlhLmhLMgFMFLbMBBgcNVcfNCcfSVSSNBq
    jRDSzjCjjMRMrHzMRCDHMDjBnlQbbnQwLwrNLPwnTPQrlc
    sZBqdZqsWgFBpgppGJqllPllwnbQwTwsswQPwN
    gJgtJJBtqJqWBGzjRCHDDzRmDtVV
    GRBWbbWnGNhbwSsfPfmrlslWsS
    HLVCgCLpMgcLVDcDCgmlvstSlsstPtSSSlscvl
    LzQDQzMMzJzFQVDJgCzJHJZRZBNbqGFhNFwBGhbhBhBm
    JNsHhdPZSdZJjSHzzNwvwGgBFmBmvptJbFvm
    WrDrwqqqQWVMCvMvGbGbbFFbFp
    rqqLncqnlCncwQWCwWlLfSZPsZddfzzNNdhdPlZz
    rwfrwHqSdRcgwdZrDcrqDDdgNzjNjPzPJNJPtbNPbGsHNGHv
    hllLMTLLQMCzJssPsTvtFG
    QtQnpWVVMVWnVQpRZSSwZDggrcSq
    FDlqPMBdmbqMrdDqqFdFDwjHZChHHZfZWZNBsZjhfhHf
    VQJVgncpTQRJfsssGhsNWC
    NtpLLSpcLVRzzRRtpgVcLgglMwwlPlzdmDlFmFPDmqqwlF
    PqwwSqNWPqwSWqjNBwpTPpffhJfZfstRtZJRRdJsdR
    VFLFzQVgVnDVjhdJHsvhZjfg
    VVFVDDnmnzLFCzVmznFzrFlrjSCPNMBCSGSGwwwGBjPNWPwC
    zzbCGrfgbzfzCtvqdjSrvSjnvS
    cNVTLnJZRNNmQmhJNptvBlBtVjlljqqldtlB
    ZhpcJHLQhRcLZLmNQJzfFwDzzgHPFngDPPnP
    ttntdMMBZzbZZtjPfwjwTwBvvVmh
    llSllRRNsGCrCDTPfgVgTfgvsjPH
    CFclcCWGrJNDSnnWMbQTnWtLQd
    bccfdSfwFsswcbbdJFGQVGnCJLnBLnDnQLDj
    ThvHZNhZmqNWMNqvDVjcjjBQVhQBBVLB
    vWMZZNRmNMWqtWqmqHclfFgdlwRwrzzSfwbFRd
    WNzRWWZNmtNZnssNRPtCJFQJCffVJVffCvlF
    cBqBLgHHBcgqBbCJjrvrVQJfsHlr
    DhDShwchBSbdwBsqgGcbgTTRmzdNWmMRMmTdNpTMmW
    FHWZDbbPZDFHgGGPdPbJNLpJSlNjcjSphcJjFN
    ZCCrBBRwwCjcNwcljppN
    CmTTsrMfBCRsTMnnCRTmVZbgdbdGfWHPDVvdbbPV
    cgSNBScMgjBBPtBCNLVvVVvhhJJhvsMhVfWq
    TFlDrHPZHTTFmwTQHZDZTrqvvzqlJppVJvpffhqqVfJp
    DbPwrTZDQDRQQwQZrDrbbQwRRnNSBtCjtcNGjSgSLjLccC
    pdcVCpdZnZgcZgdcDWBDNcNwvBWJwc
    RRmHspRmmQfLwwJJbFBFFJNR
    rGlpfrQrqGhGqdGP
    THhNsHhdFjcDthDcjDhLBqWcLLQQJvvBbvBJbl
    GfrCSZGCzfVMrVCCzGVfSMQBBFlJlJBFFZqvWBqbbQWl
    rSrFwCwzMMzRfGrGMwPfGCVdgHDttthNPssHjmNNdDjgdD
    shmhggDsZCZWBDmsQTcTqrLPTbNbwQQrrN
    lzpFVfdjfFFGnVVHpjJGJVlprNMPNtPctTNwLtcTbwctwTnN
    jVFfzVlFSpzpFCshWmgSRgmBRb
    zZGFNPmdPdszdWddGWZlpLMLpbQbLDpblzQbtv
    wTwgwSSCHhhCSghJbpcpDglbbQbMVMpV
    BHnBRrJCHmRNfGDmfm
    CffgvfCRGngRrvGvgdnRVpPQQPSqbVZZDPDVPzFSSQ
    cMlWJTMlcTLTLtHHJlpqDLwqSzSSDDqDZDDS
    tmHTtlMmWpmsMJsCRdCNsrRGfrnffN
    lNrzNHNwzZlHmwNBpMqqnqGDZSpMTGnb
    ddjgFjjsRvGvQhQvvFjqbVTFpbVpFDJSbJVpTS
    cjsQhsjvRvGcgNtzczmtmwCCcr
    NJMJvBmBJPtMtRDnDDwDMFFWDWHG
    hZsrzshpSdjZZqSSfgpDwnwFnGCCLHDbjnGCWG
    zfgSpScsrdpmllttGvJGcm
    GLsnLVLZGZmcGVpgZLmTjTsDDTlDTHPPHWlHwD
    dNJhCCdtNJSvdDzwPlvTlQ
    BCbBrPPfRMfMJSffrMCMChrSqVcmLLFpqLFFcggLVnqgmbgc
    hMdjMndZLRnRnjclszLclQlzGwcr
    FPCCSCSpCwStJVGzsPQGslGzPbsQ
    TSSJTtfTFTwtmTFFVFDTWRvdgndjjRhnjnvHjdfR
    ZwgsnsWsWvWQHqJhGhJVCJHhCJ
    cdjlMWRRMhJLCpLL
    jjSRmRmNRNWBmdmcWjlDWFPswsPtnZQsnBsnZvvTTnvT
    vvbjLTPbQzrQQjpLzLbflfjfRDDsDlRfgDnnVD
    ZGCtHHFGzFHhMlCnDqwlgggsqf
    FJHMhHZGmNHtJhMhBJZZtZdrbSbSzbmWLLQrQTbPdbrS
    ZClGVCvLZzCLBVbdGGzVVBvVrqQMDWMHrgmgQLWrWmTgqqHH
    tNpNspcQPfHmqfgHmHHg
    nNttnwPRjFtPcccsFptPlllQGlQZbvGzVVVFzhCd
    lflmVWpDVsMmmVPlHVbbGSSbGnSHJcncnLZn
    NvTFzNwzTQvhFGSZnvgrbgJCgr
    jtRwTQFzjBNGGQQBdDsDqqlsVqRflMlPsP
    rCSJPCrBwwMdBJRCrwMTGWTWNbcjGZNGGZTb
    qzgqfgFghsHzfgHgmmfWGNGGWcNNFClbWlcCNW
    DqsnzsHLhddBDwCRJR
    sZpHjZrVQmcrbhbthzhFHzhH
    QDPMDMndqqQGqQfCDDbhFtzzLtbWzlBLLPBW
    TDMDqfGnJSnfnfvgjsjNgJvsjVQv
    bDZQbZHdQQggZfttJjGnplSnldsG
    FTrFCvWBWzTNSPNvRBGJsGjpsJjstmCLtjCt
    rhBvzRVRBBSVHDHcHMHq
    FSbSNZbZbzGzGGbNzGgcZPwlDPvlNmLLLwLLlLvvvl
    pqnqpVCrpshqmChsQnnRpRCldDHvDHLjDlvPwddlwPtwDV
    rRTCnnpCWCChTrWsrBTfbcFFmFSSmfBBGg
    QdhdWDsHhHWzPrLPSCPGvs
    gpZZmNmtjZwpBZBZgSnvFcGPrrvmncnvmC
    RVVRjZJfJVfVBZVtBNBVppZVDqMHhqTbMGlWHQhhWldRMHWd
    BPWQrRRNNMhrHhLqqGgjDJjH
    TzVmmpmtCNwscTzszcNzDCfCHJqDfGjDJJgfGCDq
    wdwmspTsVdlTcpbmVMPWBbBWRPNnFnBWMr
    VZTnVnsgrjjsqPzPwWgWPghz
    mcFdQGPMBdMSBdWbhRzzWqwLwcWt
    GQPBvpfvNvFPBvTnfjnZDHDDjsrr
    CZssCNFJBmBNFmFBNwBFCJFTtthGrrSThtSgSRtSfRTGtRrg
    LDpDbnjjDGpggGrvGg
    PLMWnWQgbQWnWbnbjqDbszHwwzwmNsFZMBmwJFZF
    hQSjFLhFLLMSSFgdWTMdGgNbNbWv
    JmPlltJBJqmzpbrrwTwrvvGqww
    HBzztRBRplzlmHmRmmsplRJZcfFcLFfHSLjSZTcfVVcLVH
    nBSQMnVQqJBGnfVfDgCrjbVbtC
    FNcPPHdTdhmBdHBvwlZjbClClfcZgjclgj
    vFdHWhTLHvnBRRqBsWSR
    TRsNNTTHRRZRRsRzJQddSpJLcQdpjs
    DMVPVVGmMGWMGtMgGtDlmMWwLLLpJfSfpjzpdQddLSmSSJdc
    tVMgGMDwMgMWDBWMttjRBZNnvNCNZrZZRbZNvZ
    wlJPVMJPPBShSlhgfTvgNNzzgNMCTg
    FLtRnDDSrvdNdrng
    FcSmpFZFFmmjWqPWJbmhGqqm
    hlBqqTlSfvNhpbfb
    fRVsVDDRtnRVfbDNCCNCNQGwNZ
    nrrRPPnHzntRrPsRVrtJVBMjlzWfFWdMjjWMqdBBlT
    zDNcnRsNNfRFFNNzRzLbRWgMZMMZcdhcBdMrBpZmmZ
    PVHHVlPDGPPtjDmmdrrGBBMpWGWd
    VVqTTlQtDCqFNzsnbLbCSJ
    ndSGSZZGwSZTBdwnwdwmWCzPQCQLffZzRgMZRggMzf
    mvqVmqrmcDqllNNtbcNcMCQMRCMCCMQfHLgvRgMg
    FhNNcrrVljFcqmTJhwnsmGdJsT
    wlmLmZLwzvVmVWVmQWzZSFJFDSqFHSSFJHhDqZ
    RsgpMNcMdRgjDcRFqCSrHSHBCFJr
    jdncssDNPsbmmwvvlPLw
    wQGHMrHGgwgVTQrrMGgGQrTtWzzPJhsfhZztWssQWbZCWh
    FjvBFSqqDbljFvSbnvFltszfWPPfWzJZBCsPtJft
    qLlDbpjFRbpdGTgLGLGTTV
    hrVJsBrpwbsMZtTLlwnqtqdc
    QDDmHWmffHCQWHjRQjCWczTTjtlzdldqVtTnTqLt
    HmfGfRNWfNWmQCRsgbsMFMhMGvpBVs
    CRzzVCZhvGQqNmcWrgpgwQFSmF
    BJsttjDtjbdLMHHsBTqBbBHMrprDSrFnFnSgrnnrpDSmWWnw
    TbMBMPPdLTbHTjHMtPzZGvzlvqCPGNlNVRVP
    QcmcrCVcdTCGRRLT
    zzgWFWVBTSWLPdMP
    JbhnBVzzfVhgztVDvqcqHwncZHNqnsnccQ
    JJVBFfJjNNNsJTwVfZJNffFRpRzRzRptRWtCtSSHWsWzCD
    rmrnhgclhQGcGnhrPjqgGMHbWRHRbRCWbzRbMSSpHWCD
    mhhjQGGjQgggqnmQnmghdQdJFZBNvZBBLNTvvTNNTLfZ
    DrBgwMCMRvMrvDgPCzdpdNtzqqlHNNtp
    jWSSZGgfGjcLfdNjFzqqFFzzFF
    nGZhTmZLLZhGPVVTgQgMRrrb
    ppqZvppdJmSLHdSfZRrrtbscgRVVgwVrHt
    hFFFzQPhNWzNhnhGVggrcbwVgBnvbwgR
    CNQWFMzWWhCflpjvZJMJdj
    pfpfmQMWmcBVfMBBmpfVQMbDGGNPDTcSNTTsSNPCCNhC
    ZZrZwvvzZrvZlZlwhwswhNSsgbDssC
    ttvdtzRzFDqRJWLVLWJJpQ
    CZZPTQPTPTJhTQTrHCBbvtLbbbRWtjbDvb
    cGfsVSVcLdSgSwBWRNNGwRNRbD
    spSffnccsgcdnnJJQlZZqJLhpMJh
    TwGGdWwdddtTsbzPzbbnTLnPLP
    gqNSMvtvcSDLLfnMnnPzFM
    NvDNDqtvRcjQVGZZGZZhwpQB
    jtgFmnqjqttQpsphzNllblzlNH
    GRMRDMGCVCHzSCbSbNNl
    LMTJRTGRLBJBwLRRHmBFQPvqmPBvtgtc
    jDjjwRDpPqqsMsDLJbJzVB
    lMNMNddvMltNfFVWbVVWJrrVLfgL
    NQQtmtFGFlGZPZcMmmcjjn
    CgCNjvSCgSQQzVZNWVnTBPTcsTVBnpPs
    bFbbLfbfdRBFhLwqFmblBJfRHtWcttcttlDpspcPWDcDptPn
    mdbFhfJrmJwfbmmFFFvBZCNCzMGrNjMQjCCZ
    TPDNHHSTNNmRfTrRMZSqwwttdbBvBMth
    VVnnFGgnQcBvMqvnhNBN
    GLzjjzGscssJGJCHljmfmTWPTCDN
    BZZNcMQjBNjNtDJgstjgtwqGRQfhGhSvPfThfqvPhfhf
    CCndrnmnnWbrnHrFbWbpbbVmGGPqLfTGhvGSPhqRLRdfSGsf
    bFssVbbblFHzrmFlMNMtcNgDtJDzZgtw
    smjMtSqQQSjtSfmDVVFHFhnHBHmbNPPH
    TgvCCJcZdwdgNvbHvPbbvBNq
    JLqRWTgLqJLCJcclgCJdWjfsSSpsfRrsQjDtspptQQ
    hNwztzgzJnnNTVFwNTNhwVhZlrpLMLZZlpZlQndLPLpQLZ
    vRDvqSSqjbqSWDvjbvBdLWspPLddZPQQLMllLp
    SfGfRmSGCSfBfjTcNFgzwMFJzwgm
    lhVBhZjjPHbThwFGrNrdvNNwFV
    DRrDLfMLSgpCdCJcfmcJCm
    LQtnprtqSRtZjHzTthlb
    GrGsqfbtsWGWWntnrrwWWWGSSDSMDcSSSwTDzPzJSJzPcT
    lmQhhVCgmffCNgmNNmCmBNRRPvDzDMhJvSSDJzzcTzvvPvMT
    VBllNBpfQgQmpLBpRBtnqWLFFnZZWWGrZrjq
    NRJdngMVwfgnwJtvlblcWLlLDHfccDbW
    PFJzBmhmjPFpJrFqLcQHLlHGDlHDQbGz
    ShJZJmPFpwdMvCCZRd
    WQDqSVWqpBCsPqPWWNscfrHfhrhrHhGFGs
    MmLRmLTjmTzTzlhGHfprhvfFhHfT
    mLZLRdgMRjtdddmdgwmtMwQSCPbnDSSCqBDwpWPQqn
    rNHwMMGDrggWwsvWMPMWWwjbCqjCBlZqvfjBqCJhfffj
    FbtFmRTpzBBZqCClpJ
    ztbzFtnzVNnNNPPDGD
    PLPFcwdLdFcbgdfSwFtWhGWGRMWMJMGCblJR
    qTpszVVjRlCHtWCT
    qzvrDqQrqznzggFZwFwQScdW
    LWLjLNjNjTwlwLZVcBVcVVZcBVQcZZ
    JhGhFdmBRdGGDnQtbPvVVdnccS
    zDrrFGFFRgRHmDNWTpjTBNTHWNjW
    fwfBVLhmwfhHsgBstWCWQnDQnlldWW
    hZvFTNJrZjZbFvNvttqWWDtcWqCtFDWn
    rbjjrjpRzRzgBLzwLgmzLh
    ZqqqWVzdSPnwBJBfwJfZTs
    FHGgjRLMJFsJTsBw
    DHRcDgHvLhDWPSCzwqnq
    LZGZLLRLZpRQBtPTjTffrHljjmsB
    wNVVwcCgNCCScwggmjHjTPmQPsTHmlSs
    gbbwbqhNCQcbqqVchWhtRZDJWJDtZLWL
    CmTmvvmvzCCCgzzVQmTQvTjjGRGShwSHwRrRSSSSDNHSFN
    PqZqWdqlplsqBJMMsMMnGRJRbbNwNhrrhShGShFD
    fBWBWdZppqpqDMBdlfcTCTLtLtLCQfQvcmgv
    pntdtdHHWHqnptGpqHqNgMQwPPPnZMZZZZcfgc
    LFmLSVBRTSBBRrffTQgMfQMtJZQT
    bmRCSSSjRCtSrRChjqqGqpppGhqDGp
    dGGhhfNfgRTGLcpL
    BmCCwQMQqmQrBCBJLpbVTFbHcgcbLTMc
    JrpqJJmqqqqmzqqwmwNlzfvltDPltfshlhNN
    VCCbMJfJlgRCnNGVNnvFvVBF
    STsgcZdghZsqSttBnsGnBtBtHt
    qDcjgDphjhSghZTQgCJWQWWfwfRzWlwJzJ
    JHMVMvmvRcdbmrRHQBBGjcjfFQfChSfj
    NltNtZllgZtgtnpnqNWpgCrCBQzBGzFhQrGSSBCzWh
    pDrwnqLlvDVmPbss
    dbrpbSrwBjswsSjCwqllLqFtqLcrGqqFtF
    RvfJDQnRpHvvQfRvvQRJFDqzcWltFFlzcLttWltW
    ZpnRVZHmvHnTnPZZPHfHmVwdjVghwgVSBgdBBCwgdC
    WRCBGWvNgHnMcFwnpC
    ltlstrjlJNlfrZZqDJtNLsHnmwwpcHphhFPMFjwhmnFp
    TStJssLstJLtqTsNgvvSBNzzvWvGRz
    VBjdWdGcqWdBVCFRmHwfCRRV
    DLzNpqbDzDNbrJvltMLJLRRmtRFTSRmTmFwfRHRTFf
    zvvJNLgNqGcnjgnP
    JjdnFfbdbdQMbQzjtRcwcCvbvBqRBCwt
    LlNHlWGprPCVVBsVzqNR
    hLmgTlrpPPHrLprHrTTGggHWzhZFSJDfhMdnjjZfFfdFMjFz
    bDbwRpCSRgqqMfMf
    HzzPcPnhzlhsQzHhHnTggBBqTQTgVQqBqjZW
    tnsrFccnzsDvGpNGqNtq
    GmPsPrsSlswNmcLzMvnpnmMpLBCf
    glDTZRDqRTjRCvjvfBpfCzvp
    DHlJVhJRDTbqZDqSNVrNwtVrQwSSGs
    nNnDwqDwFVgDwDnCgLnLpCVWdBMRpsPdMPPjRHRHHRdBWj
    tQtfTtJtJmlTQrTtTlhfzrmdHzMMRMsBPPddjddBPPdWsB
    bbhtQTfTTsmmbStnqGFGNDbFDgFVnw
    dsVpDPBMHVdHpplpvdHjRjmmjRTMTFFrrTTFQq
    LzzWZLGCzCWNjfmRfBhmQjZq
    zSSSwJwSBzNtzLBbwbSGLzWVvcvpHdssDllVJgVHVcdDPv
    RWfQBDTBLQWpDLNRZjZwHHddjHNhZdtv
    ScCCzSszFzJccPHHvmjHvjhpmHsj
    FPclgFVCbcngVgnpWQqqRfLBDBrR
    cRLLVwcsctwmbVcszztwtRMvNrCpTggqFrTvvhCVpghBqh
    PdSDGdnZQfGDfDjWjWWgvCqFhpqvpNZgCTTvrp
    dGnDHWnSQdJPDSFLLcJmRzzLLLRRcl
    lCSqlcCcBqBCCwGwnNWnnFwBHF
    WMZLMPbPhQddRbMpbbLbRLLHDFgjFGDmFNZgNnDGNHGGjD
    dTVPPQbPbMdQMzvVrWvczrCJqv
    vzscdHcHZzHzCCHlQTTTCcslMGPStmSlpDDSSSgSPDNBmNtl
    FWVMFhFMMqWhFVFbDBDDhpmpGtPSDpGG
    fRLbFfwWWLnVjMdzzQHQJnnvQs
    SmPdRbWZdSqqzSPmbdWFFQgcQnvncgQGQMMT
    BfBLmVNjprVVNlVBrpBlHpNrgQFHGCGgvTQTMGFFgMCvgQcQ
    BjjJfVLBfNffJbZDqtDsdzzm
    NLgtLsSggjqgqpLLDjsjmcJfvpmFmmJmvPpwhBJB
    lMnlZMtdCMrRRnRbTddWbVwcmPfFmhJwPfwJmvfwFvPl
    MnRrnGWRbgQqtNGDjt
    dSdrTbTtLJCcttcFVw
    PhsgQQGPZshvpQZGgsrBllVFlHVpFllJJrFH
    gqsGPgMZhgvQbzrzTfSzMTLf
    pqbDdQWqCgBfbbfFfB
    vtjnmzLcmhBdzTFgTsRP
    LZGmjvJGGctnLtvcchSjmhcLqNHCwVdQZwDwWDNpCwqHdDwQ
    wlMWSSHWShSMbDSwVhCrNjJmcrDmGRRCGCjN
    FHZdHftFFQnqsQqsQttjvGrJccmdGGcrNdRNmG
    pHpzPpQHpsPzPlzlbSgSSMLwzh
    fCQDLlDQTSjbHDqH
    ZhrsrZZZhcclwNswGGwbwF
    rcWhlhlpMJpMZmgtBCzCttCCRfdp
    zLnCMLNTvtGNpNvNjhRHgZhHvZdZHdjD
    fSsWWqScTfJJqfJFFJwswhdHhhhdhDdjbjZbhhDj
    WsWmfcqBWfTfsrntrLmplCLttm
    ljssbqMMPbHPlsbcWZNLLsWJWRFvvZfW
    SzgggDDwTzrQmDQgdSSWvdJLFGffRvZG
    zCzCDCrznnTTmCbbpvlPHtCPtb
    TZSwNPpcgpNPbwbhhbwrwJqh
    BlCDtvvgLWGCLffGfLzLrMqnnbDDHbmnnnJrhnVJ
    lzBjdCjCGCjfGjjLGBGGjlCSsRppcdpRNdRSPQcRPQZTgT
    TsFTrvGmZGfvZfZFzNNZrhClmRcBgCMwQwQPCPMPRP
    bpnnVVJtSDgRBwbQRwlR
    jpSnqLpqDJDJLDjWDWLWvvzfZZvqvNsGTHGGFfZl
    bzbzznqfCpzvhCSMfbCbpCFhtHGHHJdtHJGhFsmshJJG
    DLWRLjRrmNPQjZZlQPsFGFggVcWcFddggdsg
    rjrZPwwDRlLLBjQlRRlPDpmbqzpqnnCSCfTMwMqSvC
    FmcGcjLRPjQwQjMQrwHQ
    btJzJbVNdBJJtzTdGBbdBztGrQhhQWhMwHrhrHSHgHQfhMVS
    JJDpdDTtCtzNptnTJBznnvLCCvcFqsRqFcvZclLGRR
""".trimIndent()
