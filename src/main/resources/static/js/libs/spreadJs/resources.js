var uiResource = {
    toolBar: {
        zoom: {
            title: "Zoom",
            zoomOption: {
                twentyFivePercentSize: "25%",
                fiftyPercentSize: "50%",
                seventyFivePercentSize: "75%",
                defaultSize: "100%",
                oneHundredTwentyFivePercentSize: "125%",
                oneHundredFiftyPercentSize: "150%",
                twoHundredPercentSize: "200%",
                threeHundredPercentSize: "300%",
                fourHundredPercentSize: "400%"
            }
        },
        clear: {
            title: "清除",
            clearActions: {
                clearAll: "全部清除",
                clearFormat: "清除样式"
            }
        },
        export: {
            title: "保存",
            exportActions: {
                exportJson: "导出到JSON",
                exportExcel: "导出到Excel"
            }
        },
        downloadTitle: "保存文件",
        download: "右击另存为...",
        showInspector: "Show Inspector",
        hideInspector: "Hide Inspector",
        importJson: "导入JSON",
        importFile: "导入文件",
        insertTable: "插入表格",
        insertPicture: "插入图片",
        insertComment: "插入说明",
        insertSparkline: "Insert Sparkline",
        insertChart: "Insert Chart",
        insertSlicer: "Insert Slicer"
    },
    tabs: {
        spread: "spread",
        sheet: "工作表",
        cell: "单元格",
        table: "表格",
        data: "数据",
        comment: "注释",
        picture: "图片",
        sparklineEx: "迷你图",
        chartEx: "Chart",
        slicer: "切片机"
    },
    spreadTab: {
        general: {
            title: "General",
            allowDragDrop: "Allow Drag and Drop",
            allowDragFill: "Allow Drag and Fill",
            allowZoom: "Allow Zoom",
            allowOverfolow: "Allow Overflow",
            showDragFillSmartTag: "Show Drag Fill Smart Tag"
        },
        calculation: {
            title: "计算",
            referenceStyle: {
                title: "参考风格",
                r1c1: "R1C1",
                a1: "A1"
            }
        },
        scrollBar: {
            title: "滚动条",
            showVertical: "垂直滚动条",
            showHorizontal: "水平滚动条",
            maxAlign: "滚动条最大对齐",
            showMax: "滚动条显示最大",
            scrollIgnoreHidden: "滚动忽略隐藏行或列"
        },
        tabStip: {
            title: "页框",
            visible: "选项卡可见",
            newTabVisible: "新标签可见",
            editable: "选项卡编辑",
            showTabNavigation: "显示选项卡导航"
        },
        color: {
            title: "颜色",
            spreadBackcolor: "spread背景色",
            grayAreaBackcolor: "灰色区域的背景颜色"
        },
        tip: {
            title: "提示",
            showDragDropTip: "显示拖放技巧",
            showDragFillTip: "显示拖动填充技巧",
            scrollTip: {
                title: "滚动提示",
                values: {
                    none: "没有",
                    horizontal: "水平",
                    vertical: "垂直",
                    both: "二者"
                }
            },
            resizeTip: {
                title: "调整提示",
                values: {
                    none: "没有",
                    column: "列",
                    row: "行",
                    both: "两者"
                }
            }
        },
        sheets: {
            title: "工作表",
            sheetName: "工作表名",
            sheetVisible: "工作表可见"
        },
        cutCopy: {
            title: "剪切/复制",
            cutCopyIndicator: {
                visible: "显示指示器",
                borderColor: "显示器边框颜色"
            },
            allowCopyPasteExcelStyle: "允许复制粘贴Excel格式",
            allowExtendPasteRange: "允许扩展粘贴范围",
            copyPasteHeaderOptions: {
                title: "标题选项",
                option: {
                    noHeaders: "没有标题",
                    rowHeaders: "行标题",
                    columnHeaders: "列标题",
                    allHeaders: "所有标题"
                }
            }
        },
        spreadTheme: {
            title: "spread主题",
            theme: {
                title: "主题",
                option: {
                    spreadJS: "SpreadJS",
                    excel2013White: "Excel2013 White",
                    excel2013LightGray: "Excel2013 Light Gray",
                    excel2013DarkGray: "Excel2013 Dark Gray",
                    excel2016Colorful: "Excel2016 Colorful",
                    excel2016DarkGray: "Excel2016 Dark Gray"
                }
            }
        },
        resizeZeroIndicator: {
            title: "调整零位指示器",
            option: {
                defaultValue: "默认",
                enhanced: "增强"
            }
        }
    },
    sheetTab: {
        general: {
            title: "一般",
            rowCount: "行",
            columnCount: "列",
            name: "名称",
            tabColor: "标签的颜色"
        },
        freeze: {
            title: "冻结",
            frozenRowCount: "标题行",
            frozenColumnCount: "标题列",
            trailingFrozenRowCount: "页脚行",
            trailingFrozenColumnCount: "页脚栏",
            frozenLineColor: "颜色",
            freezePane: "冻结",
            unfreeze: "解冻"
        },
        gridLine: {
            title: "网格线",
            showVertical: "垂直可视",
            showHorizontal: "可见的水平",
            color: "颜色"
        },
        header: {
            title: "标题",
            showRowHeader: "行标题可见",
            showColumnHeader: "列标题可见"
        },
        selection: {
            title: "选择",
            borderColor: "边框颜色",
            backColor: "背景色",
            hide: "隐藏选择",
            policy: {
                title: "策略",
                values: {
                    single: "单一",
                    range: "范围",
                    multiRange: "多量程"
                }
            },
            unit: {
                title: "单元",
                values: {
                    cell: "单元",
                    row: "行",
                    column: "列"
                }
            }
        },
        protection: {
            title: "保护",
            protectSheet: "保护工作表",
            selectLockCells: "选择锁定的单元格",
            selectUnlockedCells: "选择未锁定的单元格",
            sort: "排序",
            useAutoFilter: "使用“自动筛选”",
            resizeRows: "调整行",
            resizeColumns: "调整列",
            editObjects: "编辑对象"
        }
    },
    cellTab: {
        style: {
            title: "风格",
            fontFamily: "字体",
            fontSize: "大小",
            foreColor: "字体颜色",
            backColor: "背景色",
            waterMark: "标签",
            cellPadding: "填充",
            cellLabel: {
                title: "标签选项",
                visibility: "可见性",
                visibilityOption: {
                    auto: "自动",
                    visible: "可见",
                    hidden: "隐藏"
                },
                alignment: "对齐",
                alignmentOption: {
                    topLeft: "左上方",
                    topCenter: "顶部中心",
                    topRight: "右上方",
                    bottomLeft: "左下角",
                    bottomCenter: "底部中心",
                    bottomRight: "右下角"
                },
                fontFamily: "字体",
                fontSize: "大小",
                foreColor: "字体颜色",
                labelMargin: "边缘"
            },
            borders: {
                title: "边框",
                values: {
                    bottom: "下边框",
                    top: "上边框",
                    left: "左边框",
                    right: "右边框",
                    none: "没边框",
                    all: "全边框",
                    outside: "外边框",
                    thick: "粗边框",
                    doubleBottom: "底部的双边框",
                    thickBottom: "醋底边框",
                    topBottom: "上下边框",
                    topThickBottom: "上下粗边框",
                    topDoubleBottom: "顶部和双底边框"
                }
            }
        },
        border: {
            title: "边框",
            rangeBorderLine: "线",
            rangeBorderColor: "颜色",
            noBorder: "没有",
            outsideBorder: "外边框",
            insideBorder: "在边框",
            allBorder: "所有边框",
            leftBorder: "左边框",
            innerVertical: "内部垂直",
            rightBorder: "右边框",
            topBorder: "上边框",
            innerHorizontal: "内部水平",
            bottomBorder: "底部边框"
        },
        alignment: {
            title: "对齐",
            top: "顶部",
            middle: "中间",
            bottom: "底部",
            left: "左边",
            center: "中心",
            right: "右边",
            wrapText: "文字换行",
            decreaseIndent: "减少缩进",
            increaseIndent: "增加缩进"
        },
        format: {
            title: "格式",
            commonFormat: {
                option: {
                    general: "一般",
                    number: "数量",
                    currency: "通用",
                    accounting: "会计",
                    shortDate: "短日期",
                    longDate: "长日期",
                    time: "时间",
                    percentage: "百分比",
                    fraction: "分数",
                    scientific: "系统",
                    text: "文本"
                }
            },
            percentValue: "0%",
            commaValue: "#,##0.00; (#,##0.00); \"-\"??;@",
            custom: "自定义",
            setButton: "设置"
        },
        merge: {
            title: "合并单元格",
            mergeCells: "合并",
            unmergeCells: "分解"
        },
        cellType: {
            title: "单元类型"
        },
        conditionalFormat: {
            title: "条件格式",
            useConditionalFormats: "条件格式"
        },
        protection: {
            title: "保护",
            lock: "锁定",
            sheetIsProtected: "保护工作表",
            sheetIsUnprotected: "不锁定工作表"
        }
    },
    tableTab: {
        tableStyle: {
            title: "表格样式",
            light: {
                light1: "light1",
                light2: "light2",
                light3: "light3",
                light7: "light7"
            },
            medium: {
                medium1: "medium1",
                medium2: "medium2",
                medium3: "medium3",
                medium7: "medium7"
            },
            dark: {
                dark1: "dark1",
                dark2: "dark2",
                dark3: "dark3",
                dark7: "dark7"
            }
        },
        general: {
            title: "一般",
            tableName: "名称"
        },
        options: {
            title: "选项",
            filterButton: "过滤按钮",
            headerRow: "标题行",
            totalRow: "总计行",
            bandedRows: "带状行",
            bandedColumns: "带状列",
            firstColumn: "第一列",
            lastColumn: "最后列"
        }
    },
    dataTab: {
        sort: {
            title: "Sort & Filter",
            asc: "Sort A-Z",
            desc: "Sort Z-A",
            filter: "Filter"
        },
        group: {
            title: "组合",
            group: "组合",
            ungroup: "取消组合",
            showDetail: "显示细节",
            hideDetail: "隐藏的细节",
            showRowOutline: "显示行提纲",
            showColumnOutline: "显示列提纲"
        },
        dataValidation: {
            title: "数据验证",
            setButton: "设置",
            clearAllButton: "清除所有",
            circleInvalidData: "无效数据",
            setting: {
                title: "设置",
                values: {
                    validatorType: {
                        title: "验证器",
                        option: {
                            anyValue: "任意值",
                            number: "数字",
                            list: "列表",
                            formulaList: "公式列表",
                            date: "Date",
                            textLength: "文本长度",
                            custom: "自定义"
                        }
                    },
                    ignoreBlank: "忽略空白",
                    validatorComparisonOperator: {
                        title: "操作符",
                        option: {
                            between: "之间",
                            notBetween: "不在...之间",
                            equalTo: "等于",
                            notEqualTo: "不等于",
                            greaterThan: "大于",
                            lessThan: "不到",
                            greaterThanOrEqualTo: "大于或等于",
                            lessThanOrEqualTo: "小于或等于"
                        }
                    },
                    number: {
                        minimum: "最小",
                        maximum: "最大",
                        value: "值",
                        isInteger: "是整数"
                    },
                    source: "源",
                    date: {
                        startDate: "开始日期",
                        endDate: "结束日期",
                        value: "值",
                        isTime: "是时间"
                    },
                    formula: "公式"
                }
            },
            inputMessage: {
                title: "输入消息",
                values: {
                    showInputMessage: "显示单元格何时被选中。",
                    title: "标题",
                    message: "消息"
                }
            },
            errorAlert: {
                title: "错误警报",
                values: {
                    showErrorAlert: "输入无效数据后显示。",
                    alertType: {
                        title: "警报类型",
                        option: {
                            stop: "停止",
                            warning: "等待",
                            information: "通知"
                        }
                    },
                    title: "标题",
                    message: "消息"
                }
            }
        }
    },
    commentTab: {
        general: {
            title: "一般",
            dynamicSize: "动态尺寸",
            dynamicMove: "动态移动",
            lockText: "锁定文本",
            showShadow: "显示阴影"
        },
        font: {
            title: "字体",
            fontFamily: "字体",
            fontSize: "大小",
            fontStyle: {
                title: "风格",
                values: {
                    normal: "正常的",
                    italic: "斜体",
                    oblique: "倾斜的",
                    inherit: "继承"
                }
            },
            fontWeight: {
                title: "重量",
                values: {
                    normal: "正常的",
                    bold: "明显的",
                    bolder: "醒目的",
                    lighter: "较淡的"
                }
            },
            textDecoration: {
                title: "装饰",
                values: {
                    none: "没有",
                    underline: "下划线",
                    overline: "跨线",
                    linethrough: "通过"
                }
            }
        },
        border: {
            title: "边框",
            width: "宽度",
            style: {
                title: "风格",
                values: {
                    none: "没有",
                    hidden: "隐藏",
                    dotted: "布满",
                    dashed: "虚线",
                    solid: "实心",
                    double: "复数",
                    groove: "沟槽",
                    ridge: "脊",
                    inset: "插图",
                    outset: "开端"
                }
            },
            color: "颜色"
        },
        appearance: {
            title: "外观",
            horizontalAlign: {
                title: "水平",
                values: {
                    left: "左边",
                    center: "中间",
                    right: "右边",
                    general: "一般"
                }
            },
            displayMode: {
                title: "显示模式",
                values: {
                    alwaysShown: "总是显示",
                    hoverShown: "悬停显示"
                }
            },
            foreColor: "前景色",
            backColor: "背景色",
            padding: "填充",
            zIndex: "Z指数",
            opacity: "不透明度"
        }
    },
    pictureTab: {
        general: {
            title: "一般",
            moveAndSize: "用单元格移动和大小",
            moveAndNoSize: "移动，不要用单元格大小",
            noMoveAndSize: "不要移动和与单元格大小",
            fixedPosition: "固定位置"
        },
        border: {
            title: "边框",
            width: "宽度",
            radius: "半径",
            style: {
                title: "风格",
                values: {
                    solid: "固体",
                    dotted: "布满",
                    dashed: "虚线",
                    double: "复数",
                    groove: "常规",
                    ridge: "脊",
                    inset: "插图",
                    outset: "开端"
                }
            },
            color: "颜色"
        },
        appearance: {
            title: "外观",
            stretch: {
                title: "拉伸",
                values: {
                    stretch: "拉伸",
                    center: "中心",
                    zoom: "变焦",
                    none: "没有"
                }
            },
            backColor: "背景色"
        }
    },
    sparklineExTab: {
        pieSparkline: {
            title: "馅饼迷你图设置",
            values: {
                percentage: "百分比",
                color: "颜色 ",
                setButton: "设置"
            }
        },
        areaSparkline: {
            title: "面积迷你图设置",
            values: {
                line1: "Line 1",
                line2: "Line 2",
                minimumValue: "最小值",
                maximumValue: "最大值",
                points: "点",
                positiveColor: "积极的颜色",
                negativeColor: "彩色负片",
                setButton: "设置"
            }
        },
        boxplotSparkline: {
            title: "箱形图迷你图设置",
            values: {
                points: "Points",
                boxplotClass: "BoxPlotClass",
                scaleStart: "ScaleStart",
                scaleEnd: "ScaleEnd",
                acceptableStart: "AcceptableStart",
                acceptableEnd: "AcceptableEnd",
                colorScheme: "ColorScheme",
                style: "Style",
                showAverage: "Show Average",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        bulletSparkline: {
            title: "子弹的迷你图设置",
            values: {
                measure: "测量",
                target: "目标",
                maxi: "Maxi",
                forecast: "预测",
                good: "好的",
                bad: "坏的",
                tickunit: "刻度单位",
                colorScheme: "配色方案",
                vertical: "垂直",
                setButton: "设置"
            }
        },
        cascadeSparkline: {
            title: "级联迷你图设置",
            values: {
                pointsRange: "点的范围",
                pointIndex: "点指数",
                minimum: "最小数",
                maximum: "最大数",
                positiveColor: "彩色正片",
                negativeColor: "彩色底片",
                labelsRange: "标签的范围",
                vertical: "垂直",
                setButton: "设置"
            }
        },
        compatibleSparkline: {
            title: "兼容迷你图设置",
            values: {
                data: {
                    title: "数据",
                    dataOrientation: "数据定位",
                    dateAxisData: "时间轴的数据",
                    dateAxisOrientation: "时间轴的方向",
                    displayEmptyCellAs: "DisplayEmptyCellAs",
                    showDataInHiddenRowOrColumn: "Show data in hidden rows and columns"
                },
                show: {
                    title: "Show",
                    showFirst: "Show First",
                    showLast: "Show Last",
                    showHigh: "Show High",
                    showLow: "Show Low",
                    showNegative: "Show Negative",
                    showMarkers: "Show Markers"
                },
                group: {
                    title: "Group",
                    minAxisType: "MinAxisType",
                    maxAxisType: "MaxAxisType",
                    manualMin: "ManualMin",
                    manualMax: "ManualMax",
                    rightToLeft: "RightToLeft",
                    displayXAxis: "Display XAxis"
                },
                style: {
                    title: "Style",
                    negative: "Negative",
                    markers: "Markers",
                    axis: "Axis",
                    series: "Series",
                    highMarker: "High Marker",
                    lowMarker: "Low Marker",
                    firstMarker: "First Marker",
                    lastMarker: "Last Marker",
                    lineWeight: "Line Weight"
                },
                setButton: "Set"
            }
        },
        hbarSparkline: {
            title: "HbarSparkline Setting",
            values: {
                value: "Value",
                colorScheme: "ColorScheme",
                setButton: "Set"
            }
        },
        vbarSparkline: {
            title: "VarSparkline Setting",
            values: {
                value: "Value",
                colorScheme: "ColorScheme",
                setButton: "Set"
            }
        },
        paretoSparkline: {
            title: "ParetoSparkline Setting",
            values: {
                points: "Points",
                pointIndex: "PointIndex",
                colorRange: "ColorRange",
                highlightPosition: "HighlightPosition",
                target: "Target",
                target2: "Target2",
                label: "Label",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        pieSparkline: {
            title: "PieSparkline Setting",
            values: {
                percentage: "Percentage",
                color: "Color",
                setButton: "Set"
            }
        },
        scatterSparkline: {
            title: "ScatterSparkline Setting",
            values: {
                points1: "Points1",
                points2: "Points2",
                minX: "MinX",
                maxX: "MaxX",
                minY: "MinY",
                maxY: "MaxY",
                hLine: "HLine",
                vLine: "VLine",
                xMinZone: "XMinZone",
                xMaxZone: "XMaxZone",
                yMinZone: "YMinZone",
                yMaxZone: "YMaxZone",
                color1: "Color1",
                color2: "Color2",
                tags: "Tags",
                drawSymbol: "Draw Symbol",
                drawLines: "Draw Lines",
                dashLine: "Dash Line",
                setButton: "Set"
            }
        },
        spreadSparkline: {
            title: "SpreadSparkline Setting",
            values: {
                points: "Points",
                scaleStart: "ScaleStart",
                scaleEnd: "ScaleEnd",
                style: "Style",
                colorScheme: "ColorScheme",
                showAverage: "Show Average",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        stackedSparkline: {
            title: "StackedSparkline Setting",
            values: {
                points: "Points",
                colorRange: "ColorRange",
                labelRange: "LabelRange",
                maximum: "Maximum",
                targetRed: "TargetRed",
                targetGreen: "TargetGreen",
                targetBlue: "TargetBlue",
                targetYellow: "TargetYellow",
                color: "Color",
                highlightPosition: "HighlightPosition",
                textOrientation: "TextOrientation",
                textSize: "TextSize",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        variSparkline: {
            title: "VariSparkline Setting",
            values: {
                variance: "Variance",
                reference: "Reference",
                mini: "Mini",
                maxi: "Maxi",
                mark: "Mark",
                tickunit: "TickUnit",
                colorPositive: "ColorPositive",
                colorNegative: "ColorNegative",
                legend: "Legend",
                vertical: "Vertical",
                setButton: "Set"
            }
        },
        monthSparkline: {
            title: "MonthSparkline Setting"
        },
        yearSparkline: {
            title: "YearSparkline Setting"
        },
        monthYear: {
            data: "Data",
            month: "Month",
            year: "Year",
            emptyColor: "Empty Color",
            startColor: "Start Color",
            middleColor: "Middle Color",
            endColor: "End Color",
            colorRange: "Color Range",
            setButton: "set"
        },
        orientation: {
            vertical: "Vertical",
            horizontal: "Horizontal"
        },
        axisType: {
            individual: "Individual",
            custom: "Custom"
        },
        emptyCellDisplayType: {
            gaps: "Gaps",
            zero: "Zero",
            connect: "Connect"
        },
        boxplotClass: {
            fiveNS: "5NS",
            sevenNS: "7NS",
            tukey: "Tukey",
            bowley: "Bowley",
            sigma: "Sigma3"
        },
        boxplotStyle: {
            classical: "Classical",
            neo: "Neo"
        },
        paretoLabel: {
            none: "None",
            single: "Single",
            cumulated: "Cumulated"
        },
        spreadStyle: {
            stacked: "Stacked",
            spread: "Spread",
            jitter: "Jitter",
            poles: "Poles",
            stackedDots: "StackedDots",
            stripe: "Stripe"
        }
    },
    chartExTab: {
        fontSize: "字体大小",
        color: "颜色",
        lineColor: "线条颜色",
        fontFamily: "字形体系",
        chartType: "图表类型",
        backColor: "背景色",
        values: {
            chartArea: {
                title: "图表区",
                backColor: "背景色",
                color: "颜色",
                fontSize: "字体大小",
                fontFamily: "字体"
            },
            chartTitle: {
                title: "图表标题",
                text: "文本",
                chartType: "图标类型",
                dataRange: "数据范围"
            },
            series: {
                title: "串联",
                seriesIndex:'串联',
                axisGroup: "轴群",
                lineWidth:"线宽",
                primary:"初级",
                secondary:"次要的"
            },
            legend: {
                title: "图例",
                position: {
                    title: "位置",
                    values: {
                        left: "左",
                        right: "右",
                        top: "上",
                        bottom: "下"
                    }
                },
                showLegend: "显示图例"
            },
            dataLabels: {
                title: "数据标签",
                showValue: "显示值",
                showSeriesName: "显示系列名称",
                showCategoryName: "显示类别名称",
                position: {
                    title: "位置",
                    values: {

                    }
                },
                color: "颜色"
            },
            axes: {
                title: "轴线",
                axisType: {
                    title: "轴线类型",
                    values: {
                        primaryCategory: "基本范畴",
                        primaryValue: "原始值",
                        secondaryCategory: "第二范畴",
                        secondaryValue: "二次价值"
                    }
                },
                aixsTitle: "标题",
                titleColor: "标题颜色",
                titleFontSize: "标题大小",
                titleFontFamily: "标题字体",
                showMajorGridline: "展示Major Gridline",
                showMinorGridline: "展示 Minor Gridline",
                showAxis: "显示轴线",
                lineColor: "线色",
                lineWidth: "线宽",
                TickPosition: {
                    majorTitle: "Major Tick 位置",
                    minorTitle: "Minor Tick 位置",
                    values: {
                        cross: "Cross",
                        inside: "Inside",
                        none: "None",
                        outside: "Outside"
                    }
                },
                majorUnit: "主要单位",
                minorUnit: "次要单位",
                majorGridlineWidth: "主要网格线宽",
                minorGridlineWidth: "次要网格线宽",
                majorGridlineColor: "主要网格线颜色",
                minorGridlineColor: "次要网格线颜色",
                tickLabelPosition: {
                    title: "Tick Label Position",
                    values: {
                        none: "None",
                        nextToAxis: "下轴"
                    }
                }

            }

        },
        setButton: "设置",
        combo: {
            title: "聚类柱线图设置",
            value: {}
        }
    },
    slicerTab: {
        slicerStyle: {
            title: "切片器样式",
            light: {
                light1: "light1",
                light2: "light2",
                light3: "light3",
                light5: "light5",
                light6: "light6"
            },
            dark: {
                dark1: "dark1",
                dark2: "dark2",
                dark3: "dark3",
                dark5: "dark5",
                dark6: "dark6"
            }
        },
        general: {
            title: "一般",
            name: "名称",
            captionName: "标题名称",
            itemSorting: {
                title: "项目排序",
                option: {
                    none: "没有",
                    ascending: "提升",
                    descending: "下降"
                }
            },
            displayHeader: "显示表头"
        },
        layout: {
            title: "布局",
            columnNumber: "列数",
            buttonHeight: "按钮的高度",
            buttonWidth: "按钮的宽度"
        },
        property: {
            title: "特性",
            moveAndSize: "用单元格移动和大小",
            moveAndNoSize: "移动，不要用单元格大小",
            noMoveAndSize: "不要移动和与单元格大小",
            locked: "锁定"
        }
    },
    colorPicker: {
        themeColors: "主题颜色",
        standardColors: "标准颜色",
        noFills: "无填充"
    },
    conditionalFormat: {
        setButton: "设置",
        ruleTypes: {
            title: "类型",
            highlightCells: {
                title: "突出单元格规则",
                values: {
                    cellValue: "单元格值",
                    specificText: "具体的文本",
                    dateOccurring: "发生的日期",
                    unique: "独特的",
                    duplicate: "重复"
                }
            },
            topBottom: {
                title: "上下规则",
                values: {
                    top10: "Top10",
                    average: "Average"
                }
            },
            dataBars: {
                title: "数据条",
                labels: {
                    minimum: "最小数",
                    maximum: "最大数",
                    type: "类型",
                    value: "值",
                    appearance: "外观",
                    showBarOnly: "只显示栏",
                    useGradient: "使用Gradien",
                    showBorder: "显示边框",
                    barDirection: "杆的方向",
                    negativeFillColor: "底片颜色",
                    negativeBorderColor: "底片边框",
                    axis: "轴",
                    axisPosition: "位置",
                    axisColor: "颜色"
                },
                valueTypes: {
                    number: "数字",
                    lowestValue: "最低",
                    highestValue: "最高",
                    percent: "百分比",
                    percentile: "百分位数",
                    automin: "Automin",
                    automax: "Automax",
                    formula: "公式"
                },
                directions: {
                    leftToRight: "从左到右",
                    rightToLeft: "从右到左"
                },
                axisPositions: {
                    automatic: "自动",
                    cellMidPoint: "单元格的中心点",
                    none: "没有"
                }
            },
            colorScales: {
                title: "颜色表",
                labels: {
                    minimum: "最小",
                    midpoint: "中点",
                    maximum: "最大",
                    type: "类型",
                    value: "值",
                    color: "颜色"
                },
                values: {
                    twoColors: "双色表",
                    threeColors: "三色表"
                },
                valueTypes: {
                    number: "数量",
                    lowestValue: "最低值",
                    highestValue: "最高值",
                    percent: "百分比",
                    percentile: "百分位数",
                    formula: "公式"
                }
            },
            iconSets: {
                title: "图标集",
                labels: {
                    style: "风格",
                    showIconOnly: "只显示图标",
                    reverseIconOrder: "逆图标顺序",

                },
                types: {
                    threeArrowsColored: "ThreeArrowsColored",
                    threeArrowsGray: "ThreeArrowsGray",
                    threeTriangles: "ThreeTriangles",
                    threeStars: "ThreeStars",
                    threeFlags: "ThreeFlags",
                    threeTrafficLightsUnrimmed: "ThreeTrafficLightsUnrimmed",
                    threeTrafficLightsRimmed: "ThreeTrafficLightsRimmed",
                    threeSigns: "ThreeSigns",
                    threeSymbolsCircled: "ThreeSymbolsCircled",
                    threeSymbolsUncircled: "ThreeSymbolsUncircled",
                    fourArrowsColored: "FourArrowsColored",
                    fourArrowsGray: "FourArrowsGray",
                    fourRedToBlack: "FourRedToBlack",
                    fourRatings: "FourRatings",
                    fourTrafficLights: "FourTrafficLights",
                    fiveArrowsColored: "FiveArrowsColored",
                    fiveArrowsGray: "FiveArrowsGray",
                    fiveRatings: "FiveRatings",
                    fiveQuarters: "FiveQuarters",
                    fiveBoxes: "FiveBoxes"
                },
                valueTypes: {
                    number: "Number",
                    percent: "Percent",
                    percentile: "Percentile",
                    formula: "Formula"
                }
            },
            removeConditionalFormat: {
                title: "None"
            }
        },
        operators: {
            cellValue: {
                types: {
                    equalsTo: "EqualsTo",
                    notEqualsTo: "NotEqualsTo",
                    greaterThan: "GreaterThan",
                    greaterThanOrEqualsTo: "GreaterThanOrEqualsTo",
                    lessThan: "LessThan",
                    lessThanOrEqualsTo: "LessThanOrEqualsTo",
                    between: "Between",
                    notBetween: "NotBetween"
                }
            },
            specificText: {
                types: {
                    contains: "Contains",
                    doesNotContain: "DoesNotContain",
                    beginsWith: "BeginsWith",
                    endsWith: "EndsWith"
                }
            },
            dateOccurring: {
                types: {
                    today: "Today",
                    yesterday: "Yesterday",
                    tomorrow: "Tomorrow",
                    last7Days: "Last7Days",
                    thisMonth: "ThisMonth",
                    lastMonth: "LastMonth",
                    nextMonth: "NextMonth",
                    thisWeek: "ThisWeek",
                    lastWeek: "LastWeek",
                    nextWeek: "NextWeek"
                }
            },
            top10: {
                types: {
                    top: "Top",
                    bottom: "Bottom"
                }
            },
            average: {
                types: {
                    above: "Above",
                    below: "Below",
                    equalOrAbove: "EqualOrAbove",
                    equalOrBelow: "EqualOrBelow",
                    above1StdDev: "Above1StdDev",
                    below1StdDev: "Below1StdDev",
                    above2StdDev: "Above2StdDev",
                    below2StdDev: "Below2StdDev",
                    above3StdDev: "Above3StdDev",
                    below3StdDev: "Below3StdDev"
                }
            }
        },
        texts: {
            cells: "仅格式化单元格:",
            rankIn: "格式值在:",
            inRange: "选定范围内的值.",
            values: "格式化值:",
            average: "选定范围内的平均值.",
            allValuesBased: "根据它们的值格式化所有单元格:",
            all: "格式的所有:",
            and: "和",
            formatStyle: "使用样式",
            showIconWithRules: "按照这些规则显示每个图标:"
        },
        formatSetting: {
            formatUseBackColor: "背景色",
            formatUseForeColor: "前景色",
            formatUseBorder: "边框"
        }
    },
    cellTypes: {
        title: "单元格类型",
        buttonCellType: {
            title: "按键单元格类型",
            values: {
                marginTop: "上边界",
                marginRight: "右边界",
                marginBottom: "下边界",
                marginLeft: "左边界",
                text: "文本",
                backColor: "背景色"
            }
        },
        checkBoxCellType: {
            title: "复选框单元格类型",
            values: {
                caption: "解说词",
                textTrue: "文本的真实",
                textIndeterminate: "文本不定",
                textFalse: "文本错误",
                textAlign: {
                    title: "文本对齐",
                    values: {
                        top: "顶部",
                        bottom: "底部",
                        left: "左边",
                        right: "右边"
                    }
                },
                isThreeState: "三状态"
            }
        },
        comboBoxCellType: {
            title: "组合框单元格类型",
            values: {
                editorValueType: {
                    title: "编辑的价值类型",
                    values: {
                        text: "文本",
                        index: "指数",
                        value: "价值"
                    }
                },
                itemsText: "项目文本",
                itemsValue: "项目价值"
            }
        },
        hyperlinkCellType: {
            title: "超链接单元类型",
            values: {
                linkColor: "链接颜色",
                visitedLinkColor: "访问过的链接颜色",
                text: "文本",
                linkToolTip: "链接的提示"
            }
        },
        clearCellType: {
            title: "没有"
        },
        setButton: "设置"
    },
    sparklineDialog: {
        title: "迷你图设置",
        sparklineExType: {
            title: "类型",
            values: {
                line: "线",
                column: "列",
                winLoss: "赢/输",
                pie: "饼",
                area: "区域",
                scatter: "散射",
                spread: "传播",
                stacked: "堆叠的",
                bullet: "子弹",
                hbar: "Hbar",
                vbar: "Vbar",
                variance: "差额",
                boxplot: "箱形图",
                cascade: "级联",
                pareto: "Pareto",
                month: "Month",
                year: "Year"
            }
        },
        lineSparkline: {
            dataRange: "数据范围",
            locationRange: "位置范围",
            dataRangeError: "数据范围无效!",
            singleDataRange: "数据范围应该在一行或一列中.",
            locationRangeError: "位置范围无效!"
        },
        bulletSparkline: {
            measure: "测量",
            target: "目标",
            maxi: "Maxi",
            forecast: "预测",
            good: "好",
            bad: "坏",
            tickunit: "刻度单位",
            colorScheme: "配色方案",
            vertical: "垂直"
        },
        hbarSparkline: {
            value: "值",
            colorScheme: "配色方案"
        },
        varianceSparkline: {
            variance: "方差",
            reference: "参考",
            mini: "Mini",
            maxi: "Maxi",
            mark: "Mark",
            tickunit: "刻度单位",
            colorPositive: "彩色正片",
            colorNegative: "彩色底片",
            legend: "传说",
            vertical: "垂直"
        },
        monthSparkline: {
            year: "年",
            month: "月",
            emptyColor: "空色",
            startColor: "开始的颜色",
            middleColor: "中间色",
            endColor: "最后的颜色",
            colorRange: "颜色范围"
        },
        yearSparkline: {
            year: "年",
            emptyColor: "空色",
            startColor: "开始的颜色",
            middleColor: "中间色",
            endColor: "最后的颜色",
            colorRange: "颜色范围"
        }
    },
    chartDialog: {
        title: "chartEx Setting",
        chartExType: {
            title: "类型",
            values: {
                columnClustered: "簇列",
                columnStacked: "叠柱",
                columnStacked100: "100% 叠柱",
                line: "线",
                lineStacked: "堆叠线",
                lineStacked100: "100% 堆叠线",
                lineMarkers: "标记线",
                lineMarkersStacked: "带标记的叠加线",
                lineMarkersStacked100: "100% 带标记的叠加线",
                pie: "饼",
                doughnut: "圆环图",
                barClustered: "分层条形图",
                barStacked: "分段条图",
                barStacked100: "100% 分段条图",
                area: "地区",
                areaStacked: "堆叠区",
                areaStacked100: "100% 堆叠区",
                xyScatter: "散射",
                xyScatterSmooth: "平滑线条和标记",
                xyScatterSmoothNoMarkers: "平滑线散射",
                xyScatterLines: "用直线和标记分散",
                xyScatterLinesNoMarkers: "直线散射",
                bubble: "Bubble",
                stockHLC: "High-Low-Close",
                stockOHLC: "Open-High-Low-Close",
                stockVHLC: "Volumn-High-Low-Close-Stock",
                stockVOHLC: "Volumn-Open-High-Low-Close-Stock",
                combo: "Clustered Column-Line"
            }
        }
    },
    slicerDialog: {
        insertSlicer: "插入切片器"
    },
    passwordDialog: {
        title: "Password",
        error: "Incorrect Password!"
    },
    tooltips: {
        style: {
            fontBold: "粗体.",
            fontItalic: "斜体。",
            fontUnderline: "下划线的文本.",
            fontOverline: "强调文本.",
            fontLinethrough: "删除线的文本."
        },
        alignment: {
            leftAlign: "向左对齐文本.",
            centerAlign: "中心的文本.",
            rightAlign: "将文本对齐到右边.",
            topAlign: "对齐文本到顶部.",
            middleAlign: "将文本对齐到中间.",
            bottomAlign: "将文本对齐到底部.",
            decreaseIndent: "减少缩进级别.",
            increaseIndent: "增加缩进级别."
        },
        border: {
            outsideBorder: "外边框",
            insideBorder: "内边框 ",
            allBorder: "全边框",
            leftBorder: "左边框",
            innerVertical: "内部垂直",
            rightBorder: "右边框",
            topBorder: "上边框",
            innerHorizontal: "内部水平",
            bottomBorder: "下边框"
        },
        format: {
            percentStyle: "百分比样式",
            commaStyle: "逗号的风格",
            increaseDecimal: "增加小数位数",
            decreaseDecimal: "减少小数位数"
        }
    },
    defaultTexts: {
        buttonText: "按钮",
        checkCaption: "检查",
        comboText: "美国，中国，日本",
        comboValue: "US,CN,JP",
        hyperlinkText: "链接文本",
        hyperlinkToolTip: "超链接的提示"
    },
    messages: {
        invalidImportFile: "无效文件，导入失败.",
        duplicatedSheetName: "复制工作表名称.",
        duplicatedTableName: "重复的表名.",
        rowColumnRangeRequired: "请选择行或列的范围.",
        imageFileRequired: "该文件必须是图像!",
        duplicatedSlicerName: "复制机的名字.",
        invalidSlicerName: "切片器名称无效."
    },
    contextMenu: {
        cutItem: "剪切",
        copyItem: "复制",
        pasteItem: "粘贴",
        insertItem: "插入",
        deleteItem: "删除",
        mergeItem: "合并单元格",
        unmergeItem: "取消合并单元格"
    },
    dialog: {
        ok: "OK",
        cancel: "Cancel"
    },
    chartDataLabels:{
        center:'中心',
        insideEnd:'内端',
        outsideEnd:'外端',
        bestFit:'最佳拟合',
        above:'上面',
        below:'下面',
    }
};

